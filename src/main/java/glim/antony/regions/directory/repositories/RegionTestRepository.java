package glim.antony.regions.directory.repositories;

import glim.antony.regions.directory.entities.Region;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("regionTestRepository")
public class RegionTestRepository implements RegionRepository {

    private List<Region> regions;

    @PostConstruct
    public void init(){
        regions = new ArrayList<>();
        regions.add(new Region(1, "Республика Адыгея", "AD"));
        regions.add(new Region(4, "Республика Алтай", "AL"));
        regions.add(new Region(2, "Республика Башкортостан", "BA"));
    }

    @Override
    public List<Region> findAll(){
        return regions;
    }

    @Override
    public Region findOneByCode(Integer code){
        for (Region r : regions) {
            if (r.getCode() == code) return r;
        }
        return null;
    }

    @Override
    public Region save(Region region) {
        regions.add(region);
        return region;
    }
}
