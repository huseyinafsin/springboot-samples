package lica;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim Pet Api dökümantasyonum")
public class PetController {
    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public  void init(){
        petList.add(new Pet(1,"Test pet",new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Yeni pet ekleme metodu", notes = "Bunu dikkatli kullan")
    public  ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "hayvar") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }


    @ApiOperation(value = "Pet listesi metodu", notes = "Bunu dikkatli kullan")
    @GetMapping
    public ResponseEntity<List<Pet>> getAll(){
        return ResponseEntity.ok(petList);
     }
}
