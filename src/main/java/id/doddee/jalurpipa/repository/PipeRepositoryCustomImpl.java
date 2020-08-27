package id.doddee.jalurpipa.repository;

import static id.doddee.jalurpipa.utils.CommonHelper.localDateToSqlDate;

import id.doddee.jalurpipa.domain.Pipe;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PipeRepositoryCustomImpl implements PipeRepositoryCustom {
    private final JdbcTemplate jdbcTemplate;

    public PipeRepositoryCustomImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean bulkUpsert(List<Pipe> pipes) {
        String query =
            "INSERT INTO pipe(id,area_id,object_id," +
            "y_start_coordinate,x_start_coordinate,y_end_coordinate,x_end_coordinate," +
            "tag_id,pipe_name,description,diameter," +
            "diameter_un,material,operation_type,construction_year," +
            "p_1_length,actual_length,comparison_standard,lok_class," +
            "pipe_material,pen_tools,row,maop_dp," +
            "max_temperature,plo_number,coi_number,ra_pipe," +
            "inspection,expired,modified,plo_document," +
            "plo_report,coi_document,ra_document) " +
            "VALUES (nextval('sequence_generator'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " +
            "ON CONFLICT (object_id) " +
            "DO UPDATE SET area_id=?," +
            "y_start_coordinate=?,x_start_coordinate=?,y_end_coordinate=?,x_end_coordinate=?," +
            "tag_id=?,pipe_name=?,description=?,diameter=?," +
            "diameter_un=?,material=?,operation_type=?,construction_year=?," +
            "p_1_length=?,actual_length=?,comparison_standard=?,lok_class=?," +
            "pipe_material=?,pen_tools=?,row=?,maop_dp=?," +
            "max_temperature=?,plo_number=?,coi_number=?,ra_pipe=?," +
            "inspection=?,expired=?,modified=?,plo_document=?," +
            "plo_report=?,coi_document=?,ra_document=?";
        jdbcTemplate.batchUpdate(
            query,
            new BatchPreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    Pipe pipe = pipes.get(i);

                    preparedStatement.setLong(1, pipe.getArea().getId());
                    preparedStatement.setLong(2, pipe.getObjectId());
                    preparedStatement.setDouble(3, pipe.getyStartCoordinate());
                    preparedStatement.setDouble(4, pipe.getxStartCoordinate());
                    preparedStatement.setDouble(5, pipe.getyEndCoordinate());
                    preparedStatement.setDouble(6, pipe.getxEndCoordinate());
                    preparedStatement.setString(7, pipe.getTagId());
                    preparedStatement.setString(8, pipe.getPipeName());
                    preparedStatement.setString(9, pipe.getDescription());
                    preparedStatement.setInt(10, pipe.getDiameter());
                    preparedStatement.setString(11, pipe.getDiameterUn());
                    preparedStatement.setString(12, pipe.getMaterial());
                    preparedStatement.setString(13, pipe.getOperationType());
                    preparedStatement.setInt(14, pipe.getConstructionYear());
                    preparedStatement.setInt(15, pipe.getp1Length());
                    preparedStatement.setInt(16, pipe.getActualLength());
                    preparedStatement.setString(17, pipe.getComparisonStandard());
                    preparedStatement.setInt(18, pipe.getLokClass());
                    preparedStatement.setString(19, pipe.getPipeMaterial());
                    preparedStatement.setString(20, pipe.getPenTools());
                    preparedStatement.setString(21, pipe.getRow());
                    preparedStatement.setString(22, pipe.getMaopDp());
                    preparedStatement.setString(23, pipe.getMaxTemperature());
                    preparedStatement.setString(24, pipe.getPloNumber());
                    preparedStatement.setString(25, pipe.getCoiNumber());
                    preparedStatement.setString(26, pipe.getRaPipe());
                    preparedStatement.setDate(27, localDateToSqlDate(pipe.getInspection()));
                    preparedStatement.setDate(28, localDateToSqlDate(pipe.getExpired()));
                    preparedStatement.setDate(29, localDateToSqlDate(pipe.getModified()));
                    preparedStatement.setString(30, pipe.getPloDocument());
                    preparedStatement.setString(31, pipe.getPloReport());
                    preparedStatement.setString(32, pipe.getCoiDocument());
                    preparedStatement.setString(33, pipe.getRaDocument());

                    preparedStatement.setLong(34, pipe.getArea().getId());
                    preparedStatement.setDouble(35, pipe.getyStartCoordinate());
                    preparedStatement.setDouble(36, pipe.getxStartCoordinate());
                    preparedStatement.setDouble(37, pipe.getyEndCoordinate());
                    preparedStatement.setDouble(38, pipe.getxEndCoordinate());
                    preparedStatement.setString(39, pipe.getTagId());
                    preparedStatement.setString(40, pipe.getPipeName());
                    preparedStatement.setString(41, pipe.getDescription());
                    preparedStatement.setInt(42, pipe.getDiameter());
                    preparedStatement.setString(43, pipe.getDiameterUn());
                    preparedStatement.setString(44, pipe.getMaterial());
                    preparedStatement.setString(45, pipe.getOperationType());
                    preparedStatement.setInt(46, pipe.getConstructionYear());
                    preparedStatement.setInt(47, pipe.getp1Length());
                    preparedStatement.setInt(48, pipe.getActualLength());
                    preparedStatement.setString(49, pipe.getComparisonStandard());
                    preparedStatement.setInt(50, pipe.getLokClass());
                    preparedStatement.setString(51, pipe.getPipeMaterial());
                    preparedStatement.setString(52, pipe.getPenTools());
                    preparedStatement.setString(53, pipe.getRow());
                    preparedStatement.setString(54, pipe.getMaopDp());
                    preparedStatement.setString(55, pipe.getMaxTemperature());
                    preparedStatement.setString(56, pipe.getPloNumber());
                    preparedStatement.setString(57, pipe.getCoiNumber());
                    preparedStatement.setString(58, pipe.getRaPipe());
                    preparedStatement.setDate(59, localDateToSqlDate(pipe.getInspection()));
                    preparedStatement.setDate(60, localDateToSqlDate(pipe.getExpired()));
                    preparedStatement.setDate(61, localDateToSqlDate(pipe.getModified()));
                    preparedStatement.setString(62, pipe.getPloDocument());
                    preparedStatement.setString(63, pipe.getPloReport());
                    preparedStatement.setString(64, pipe.getCoiDocument());
                    preparedStatement.setString(65, pipe.getRaDocument());
                }

                @Override
                public int getBatchSize() {
                    return pipes.size();
                }
            }
        );
        return true;
    }
}
