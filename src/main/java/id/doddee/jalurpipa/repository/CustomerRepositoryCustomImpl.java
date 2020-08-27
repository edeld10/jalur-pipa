package id.doddee.jalurpipa.repository;

import static id.doddee.jalurpipa.utils.CommonHelper.localDateToSqlDate;

import id.doddee.jalurpipa.domain.Customer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {
    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryCustomImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean bulkUpsert(List<Customer> customers) {
        String query =
            "INSERT INTO customer(id,area_id," +
            "object_id,y_coordinate,x_coordinate,ref_id," +
            "tag_id,name,pipe_name,year_installed," +
            "owner,station_type,line_stream,customer_type," +
            "identification,equipment,type,manu_meter," +
            "manu_filter,manu_engine,code_stand,fluida," +
            "flow_rate,pressure_in,pressure_out,temperature," +
            "base_pressure,base_temperature,inspection,expired," +
            "coi_number,coi_doc,coi_report,re_eng_rla) " +
            "VALUES (nextval('sequence_generator'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " +
            "ON CONFLICT (object_id) " +
            "DO UPDATE SET area_id=?," +
            "y_coordinate=?,x_coordinate=?,ref_id=?," +
            "tag_id=?,name=?,pipe_name=?,year_installed=?," +
            "owner=?,station_type=?,line_stream=?,customer_type=?," +
            "identification=?,equipment=?,type=?,manu_meter=?," +
            "manu_filter=?,manu_engine=?,code_stand=?,fluida=?," +
            "flow_rate=?,pressure_in=?,pressure_out=?,temperature=?," +
            "base_pressure=?,base_temperature=?,inspection=?,expired=?," +
            "coi_number=?,coi_doc=?,coi_report=?,re_eng_rla=?";
        jdbcTemplate.batchUpdate(
            query,
            new BatchPreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    Customer customer = customers.get(i);

                    preparedStatement.setLong(1, customer.getArea().getId());
                    preparedStatement.setLong(2, customer.getObjectId());
                    preparedStatement.setDouble(3, customer.getyCoordinate());
                    preparedStatement.setDouble(4, customer.getxCoordinate());
                    preparedStatement.setString(5, customer.getRefId());
                    preparedStatement.setString(6, customer.getTagId());
                    preparedStatement.setString(7, customer.getName());
                    preparedStatement.setString(8, customer.getPipeName());
                    preparedStatement.setInt(9, customer.getYearInstalled());
                    preparedStatement.setString(10, customer.getOwner());
                    preparedStatement.setString(11, customer.getStationType());
                    preparedStatement.setInt(12, customer.getLineStream());
                    preparedStatement.setString(13, customer.getCustomerType());
                    preparedStatement.setString(14, customer.getIdentification());
                    preparedStatement.setString(15, customer.getEquipment());
                    preparedStatement.setString(16, customer.getType());
                    preparedStatement.setString(17, customer.getManuMeter());
                    preparedStatement.setString(18, customer.getManuFilter());
                    preparedStatement.setString(19, customer.getManuEngine());
                    preparedStatement.setString(20, customer.getCodeStand());
                    preparedStatement.setString(21, customer.getFluida());
                    preparedStatement.setString(22, customer.getFlowRate());
                    preparedStatement.setString(23, customer.getPressureIn());
                    preparedStatement.setString(24, customer.getPressureOut());
                    preparedStatement.setString(25, customer.getTemperature());
                    preparedStatement.setString(26, customer.getBasePressure());
                    preparedStatement.setString(27, customer.getBaseTemperature());
                    preparedStatement.setDate(28, localDateToSqlDate(customer.getInspection()));
                    preparedStatement.setDate(29, localDateToSqlDate(customer.getExpired()));
                    preparedStatement.setString(30, customer.getCoiNumber());
                    preparedStatement.setString(31, customer.getCoiDoc());
                    preparedStatement.setString(32, customer.getCoiReport());
                    preparedStatement.setString(33, customer.getReEngRla());

                    preparedStatement.setLong(34, customer.getArea().getId());
                    preparedStatement.setDouble(35, customer.getyCoordinate());
                    preparedStatement.setDouble(36, customer.getxCoordinate());
                    preparedStatement.setString(37, customer.getRefId());
                    preparedStatement.setString(38, customer.getTagId());
                    preparedStatement.setString(39, customer.getName());
                    preparedStatement.setString(40, customer.getPipeName());
                    preparedStatement.setInt(41, customer.getYearInstalled());
                    preparedStatement.setString(42, customer.getOwner());
                    preparedStatement.setString(43, customer.getStationType());
                    preparedStatement.setInt(44, customer.getLineStream());
                    preparedStatement.setString(45, customer.getCustomerType());
                    preparedStatement.setString(46, customer.getIdentification());
                    preparedStatement.setString(47, customer.getEquipment());
                    preparedStatement.setString(48, customer.getType());
                    preparedStatement.setString(49, customer.getManuMeter());
                    preparedStatement.setString(50, customer.getManuFilter());
                    preparedStatement.setString(51, customer.getManuEngine());
                    preparedStatement.setString(52, customer.getCodeStand());
                    preparedStatement.setString(53, customer.getFluida());
                    preparedStatement.setString(54, customer.getFlowRate());
                    preparedStatement.setString(55, customer.getPressureIn());
                    preparedStatement.setString(56, customer.getPressureOut());
                    preparedStatement.setString(57, customer.getTemperature());
                    preparedStatement.setString(58, customer.getBasePressure());
                    preparedStatement.setString(59, customer.getBaseTemperature());
                    preparedStatement.setDate(60, localDateToSqlDate(customer.getInspection()));
                    preparedStatement.setDate(61, localDateToSqlDate(customer.getExpired()));
                    preparedStatement.setString(62, customer.getCoiNumber());
                    preparedStatement.setString(63, customer.getCoiDoc());
                    preparedStatement.setString(64, customer.getCoiReport());
                    preparedStatement.setString(65, customer.getReEngRla());
                }

                @Override
                public int getBatchSize() {
                    return customers.size();
                }
            }
        );
        return true;
    }
}
