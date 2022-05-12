package comm.tcherw.mapper;

import comm.tcherw.pojo.Brand;

import java.util.List;

public interface brandMapper {
    List<Brand> selectAll();

    List<Brand> selectSingle(Brand brand);

    void add(Brand brand);
}
