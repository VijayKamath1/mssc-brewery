package research.springcloud.msscbrewery.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import research.springcloud.msscbrewery.model.BeerDTO;
import research.springcloud.msscbrewery.service.BeerService;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService){
        this.beerService=beerService;
    }


    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId")  UUID beerId){
        System.out.println("inside beer controller");
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDTO beerDto){
        System.out.println("inside beer save");
        BeerDTO savedBeer = beerService.saveNewBeer(beerDto);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+savedBeer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }


    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, BeerDTO beerDto){
        System.out.println("inside beer UPDATEsave");
        beerService.updateBeer(beerId,beerDto);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+beerDto.getId().toString());

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



    @DeleteMapping("/{beerId}")
    public ResponseEntity handleDelete(@PathVariable("beerId") UUID beerId){
        System.out.println("inside beer delete");
        beerService.deleteBeer(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }










}
