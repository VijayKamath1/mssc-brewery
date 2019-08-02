package research.springcloud.msscbrewery.service;

import research.springcloud.msscbrewery.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById ( UUID beerId );

    BeerDTO saveNewBeer ( BeerDTO beerDto );

    void updateBeer ( UUID beerId, BeerDTO beerDto );

    void deleteBeer ( UUID beerId );
}
