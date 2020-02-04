package glim.antony.regions.directory.repositories;

import glim.antony.regions.directory.entities.Region;

import java.util.List;

public interface RegionRepository {
    List<Region> findAll();
    Region findOneByCode(Integer code);
    Region save(Region region);
}
