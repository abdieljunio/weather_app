package com.weather.weather_app.Controller;

import com.weather.weather_app.Model.Clima;
import com.weather.weather_app.Service.PrevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrevisaoController {

    @Autowired
    private PrevisaoService previsaoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/previsao")
    public String obterPrevisao(@RequestParam("cidade") String cidade, Model model) {
        Clima clima = previsaoService.obterClimaPorCidade(cidade);
        model.addAttribute("clima", clima);
        return "resultado";
    }
}
