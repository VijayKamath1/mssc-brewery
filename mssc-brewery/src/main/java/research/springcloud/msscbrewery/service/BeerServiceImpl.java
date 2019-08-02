package research.springcloud.msscbrewery.service;

import org.springframework.stereotype.Service;
import research.springcloud.msscbrewery.model.BeerDTO;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById ( UUID beerId ) {
        return BeerDTO.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").bwerStyle("Pale ALe").build();
    }

    @Override
    public BeerDTO saveNewBeer ( BeerDTO beerDto ) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("Kingfisher")
                .bwerStyle("Bitter ALe")
                .build();
    }

    @Override
    public void updateBeer ( UUID beerId, BeerDTO beerDto ) {
    }

    @Override
    public void deleteBeer ( UUID beerId ) {

    }
}
