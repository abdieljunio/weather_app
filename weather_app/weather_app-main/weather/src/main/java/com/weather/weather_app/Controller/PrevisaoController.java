package com.weather.weather_app.Controller;

import com.weather.weather_app.Model.Clima;
import com.weather.weather_app.Service.PrevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class PrevisaoController {

    @Autowired
    private PrevisaoService previsaoService;

    public PrevisaoController(PrevisaoService previsaoService) {
        this.previsaoService = previsaoService;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/resultado")
    public ModelAndView form(@RequestParam String nomeCidade) {
        ModelAndView mv = new ModelAndView("resultado");

        try {
            Clima dados = previsaoService.obterClimaPorCidade(nomeCidade);

            // Passando os valores específicos para o Thymeleaf
            mv.addObject("cidade", dados.getLocation().getName());
            mv.addObject("temperatura", dados.getCurrent().getTemp_c());
            mv.addObject("descricaoClima", dados.getCurrent().getCondition().getText());
            mv.addObject("iconeClima", dados.getCurrent().getCondition().getIcon());
            mv.addObject("umidade", dados.getCurrent().getHumidity());
            mv.addObject("vento", dados.getCurrent().getWind_mph());

        } catch (Exception e) {
            mv.addObject("error", "Cidade não encontrada. Por favor, verifique o nome digitado.");
        }
        System.out.println("Teste: " + mv);
        return mv;
    }


}
