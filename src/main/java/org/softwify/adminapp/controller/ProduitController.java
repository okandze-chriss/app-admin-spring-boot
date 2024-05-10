package org.softwify.adminapp.controller;
import jakarta.validation.Valid;
import org.softwify.adminapp.dto.ProduitDto;
import org.softwify.adminapp.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProduitController {
    private final ProduitService produitService;
    public ProduitController(ProduitService produitService) {
        super();
        this.produitService = produitService;
    }

    @GetMapping("/test")
    public String getTest(){
        return "Connected !!!!!";
    }

    @GetMapping("/list")
    public List<ProduitDto> getAppProducts(){
        return produitService.getProduits();
    }

    @GetMapping("/list/{id}")
    public ProduitDto getAppProduct(@PathVariable("id") int id){
        return produitService.getProduit(id);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProduitDto createAppProduct(@Valid @RequestBody ProduitDto appProduct){
        return produitService.createProduit(appProduct);
    }

    @PutMapping("update/{id}")
    public ProduitDto updateAppProduct(@PathVariable("id") int id, @Valid @RequestBody ProduitDto appProduct){

        return produitService.updateProduit(id, appProduct);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAppProduct(@PathVariable("id") int id){

        produitService.deleteProduit(id);
    }
}
