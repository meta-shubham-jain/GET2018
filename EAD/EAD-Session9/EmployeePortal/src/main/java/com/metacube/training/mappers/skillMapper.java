package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.models.SkillsMaster;

public class skillMapper implements RowMapper<SkillsMaster> {

    @Override
    public SkillsMaster mapRow(ResultSet resultSet, int arg1)
            throws SQLException {
        SkillsMaster skillsMaster = new SkillsMaster();
        skillsMaster.setSkillId(resultSet.getInt("skill_id"));
        skillsMaster.setSkillName(resultSet.getString("skill_name"));
        return skillsMaster;
    }
}
