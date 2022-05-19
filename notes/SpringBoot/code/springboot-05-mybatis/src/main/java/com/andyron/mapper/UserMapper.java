package com.andyron.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Andy Ron
 */
// 表示这是MyBatis的一个mapper，也可以在主程序上使用@MapperScan("com.andyron.mapper")来扫描
@Mapper
@Repository
public interface UserMapper {
}
