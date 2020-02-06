package glim.antony.regions.directory.controllers;

import glim.antony.regions.directory.entities.Region;
import glim.antony.regions.directory.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1")
public class RegionRestController {

    private RegionService regionService;

    @Autowired
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/") // http://localhost:8191/regions/rest/v1/
    @ResponseStatus(HttpStatus.OK)
    public List<Region> findAll(){
        return regionService.findAll();
    }

    @GetMapping("/{code}") // http://localhost:8191/regions/rest/v1/2
    @ResponseStatus(HttpStatus.OK)
    public Region findOneByCode(@PathVariable(name = "code") Integer code){
        Region region = regionService.findOneByCode(code);
        if (region == null) System.out.println("Region not found. (code = " + code + ")");
        return region;
    }

    @PutMapping("/") // http://localhost:8191/regions/rest/v1/
    public Region save(@RequestBody Region region){
//        if (region.getIdCode() == null) throw new ...Exception("Region have no id"); //protection
        regionService.insert(region);
        return regionService.findOneByCode(region.getCode());
    }

    @PutMapping("/{id}") // http://localhost:8191/regions/rest/v1/2
    public Region saveOrUpdate(@RequestBody Region newRegion, @PathVariable Long id){
        Region region = regionService.findOneById(id);
        if (region != null){
            region.setCode(newRegion.getCode());
            region.setTitle(newRegion.getTitle());
            region.setIso(newRegion.getIso());
            regionService.update(region);
        } else {
            region = newRegion;
            regionService.insert(region);
        }
        return regionService.findOneByCode(region.getCode());
    }
}
