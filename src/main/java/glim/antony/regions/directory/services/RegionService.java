package glim.antony.regions.directory.services;

import glim.antony.regions.directory.entities.Region;
import glim.antony.regions.directory.repositories.RegionMyBatisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RegionService {

    private static final Logger logger = LoggerFactory.getLogger(RegionService.class);

    private RegionMyBatisRepository regionRepository;

    @Autowired
    public void setRegionRepository(RegionMyBatisRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @PostConstruct
    public void init() {
        logger.info("Inserting -> {}", insert(new Region(1, "Республика Адыгея", "AD")));
        logger.info("Inserting -> {}", insert(new Region(2, "Республика Башкортостан", "BA")));
        logger.info("Inserting -> {}", insert(new Region(3, "Республика Бурятия", "BU")));
    }

    @Cacheable("regions")
    public List<Region> findAll(){
        List<Region> regions;
        logger.info("findAll -> {}", regions = regionRepository.findAll());
        return regions;
    }

    @Cacheable("regionByCode")
    public Region findOneByCode(Integer code){
        Region region;
        logger.info("findOneByCode -> {}", region = regionRepository.findOneByCode(code));
        return region;
    }

    @Cacheable("regionById")
    public Region findOneById(Long id) {
        Region region;
        logger.info("findOneById -> {}", region = regionRepository.findOneById(id));
        return region;
    }

    public Region insert(Region region){
        logger.info("insert -> {}", regionRepository.insert(region));
        return findOneByCode(region.getCode());
    }

    public Region update(Region region) {
        logger.info("update -> {}", regionRepository.update(region));
        return findOneById(region.getId());
    }

}
