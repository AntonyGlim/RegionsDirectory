package glim.antony.regions.directory.services;

import glim.antony.regions.directory.entities.Region;
import glim.antony.regions.directory.repositories.RegionRepository;
import glim.antony.regions.directory.repositories.RegionTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private RegionRepository regionRepository;

    @Autowired
    @Qualifier("regionTestRepository")
    public void setRegionRepository(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> findAll(){
        return regionRepository.findAll();
    }

    public Region findOneByCode(Integer code){
        return regionRepository.findOneByCode(code);
    }

    public Region save(Region region) {
        return regionRepository.save(region);
    }

}
