package glim.antony.regions.directory.repositories;

import glim.antony.regions.directory.entities.Region;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegionMyBatisRepository {

    @Select("SELECT * FROM regions")
    List<Region> findAll();

    @Select("SELECT TOP (1) * FROM regions WHERE code = #{code}") //TOP (1) here excessively because code UNIQUE
    Region findOneByCode(Integer code);

    @Select("SELECT TOP (1) * FROM regions WHERE id = #{id}") //TOP (1) here excessively because id UNIQUE
    Region findOneById(Long id);

    @Insert("INSERT INTO regions (code, title, iso) " +
            " VALUES (#{code}, #{title}, #{iso})")
    int insert(Region region);

    @Update("UPDATE regions SET code = #{code}, " +
            " title = #{title}, iso = #{iso} WHERE id = #{id}")
    int update(Region region);

}
