package id.doddee.jalurpipa.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import id.doddee.jalurpipa.JalurpipaApp;
import id.doddee.jalurpipa.RedisTestContainerExtension;
import id.doddee.jalurpipa.domain.Area;
import id.doddee.jalurpipa.domain.Customer;
import id.doddee.jalurpipa.repository.CustomerRepository;
import id.doddee.jalurpipa.service.CustomerService;
import id.doddee.jalurpipa.service.dto.CustomerDTO;
import id.doddee.jalurpipa.service.mapper.CustomerMapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

/**
 * Integration tests for the {@link CustomerResource} REST controller.
 */
@SpringBootTest(classes = JalurpipaApp.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class CustomerResourceIT {
    private static final Long DEFAULT_OBJECT_ID = 1L;
    private static final Long UPDATED_OBJECT_ID = 2L;

    private static final Double DEFAULT_Y_COORDINATE = 1D;
    private static final Double UPDATED_Y_COORDINATE = 2D;

    private static final Double DEFAULT_X_COORDINATE = 1D;
    private static final Double UPDATED_X_COORDINATE = 2D;

    private static final String DEFAULT_REF_ID = "AAAAAAAAAA";
    private static final String UPDATED_REF_ID = "BBBBBBBBBB";

    private static final String DEFAULT_TAG_ID = "AAAAAAAAAA";
    private static final String UPDATED_TAG_ID = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PIPE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PIPE_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_YEAR_INSTALLED = 1;
    private static final Integer UPDATED_YEAR_INSTALLED = 2;

    private static final String DEFAULT_OWNER = "AAAAAAAAAA";
    private static final String UPDATED_OWNER = "BBBBBBBBBB";

    private static final String DEFAULT_STATION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_STATION_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LINE_STREAM = 1;
    private static final Integer UPDATED_LINE_STREAM = 2;

    private static final String DEFAULT_CUSTOMER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_IDENTIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_IDENTIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_EQUIPMENT = "AAAAAAAAAA";
    private static final String UPDATED_EQUIPMENT = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_MANU_METER = "AAAAAAAAAA";
    private static final String UPDATED_MANU_METER = "BBBBBBBBBB";

    private static final String DEFAULT_MANU_FILTER = "AAAAAAAAAA";
    private static final String UPDATED_MANU_FILTER = "BBBBBBBBBB";

    private static final String DEFAULT_MANU_ENGINE = "AAAAAAAAAA";
    private static final String UPDATED_MANU_ENGINE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE_STAND = "AAAAAAAAAA";
    private static final String UPDATED_CODE_STAND = "BBBBBBBBBB";

    private static final String DEFAULT_FLUIDA = "AAAAAAAAAA";
    private static final String UPDATED_FLUIDA = "BBBBBBBBBB";

    private static final String DEFAULT_FLOW_RATE = "AAAAAAAAAA";
    private static final String UPDATED_FLOW_RATE = "BBBBBBBBBB";

    private static final String DEFAULT_PRESSURE_IN = "AAAAAAAAAA";
    private static final String UPDATED_PRESSURE_IN = "BBBBBBBBBB";

    private static final String DEFAULT_PRESSURE_OUT = "AAAAAAAAAA";
    private static final String UPDATED_PRESSURE_OUT = "BBBBBBBBBB";

    private static final String DEFAULT_TEMPERATURE = "AAAAAAAAAA";
    private static final String UPDATED_TEMPERATURE = "BBBBBBBBBB";

    private static final String DEFAULT_BASE_PRESSURE = "AAAAAAAAAA";
    private static final String UPDATED_BASE_PRESSURE = "BBBBBBBBBB";

    private static final String DEFAULT_BASE_TEMPERATURE = "AAAAAAAAAA";
    private static final String UPDATED_BASE_TEMPERATURE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INSPECTION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSPECTION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_EXPIRED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXPIRED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_COI_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_COI_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_COI_DOC = "AAAAAAAAAA";
    private static final String UPDATED_COI_DOC = "BBBBBBBBBB";

    private static final String DEFAULT_COI_REPORT = "AAAAAAAAAA";
    private static final String UPDATED_COI_REPORT = "BBBBBBBBBB";

    private static final String DEFAULT_RE_ENG_RLA = "AAAAAAAAAA";
    private static final String UPDATED_RE_ENG_RLA = "BBBBBBBBBB";

    private static final byte[] DEFAULT_FILE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_FILE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_FILE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_FILE_CONTENT_TYPE = "image/png";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCustomerMockMvc;

    private Customer customer;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createEntity(EntityManager em) {
        Customer customer = new Customer()
            .objectId(DEFAULT_OBJECT_ID)
            .yCoordinate(DEFAULT_Y_COORDINATE)
            .xCoordinate(DEFAULT_X_COORDINATE)
            .refId(DEFAULT_REF_ID)
            .tagId(DEFAULT_TAG_ID)
            .name(DEFAULT_NAME)
            .pipeName(DEFAULT_PIPE_NAME)
            .yearInstalled(DEFAULT_YEAR_INSTALLED)
            .owner(DEFAULT_OWNER)
            .stationType(DEFAULT_STATION_TYPE)
            .lineStream(DEFAULT_LINE_STREAM)
            .customerType(DEFAULT_CUSTOMER_TYPE)
            .identification(DEFAULT_IDENTIFICATION)
            .equipment(DEFAULT_EQUIPMENT)
            .type(DEFAULT_TYPE)
            .manuMeter(DEFAULT_MANU_METER)
            .manuFilter(DEFAULT_MANU_FILTER)
            .manuEngine(DEFAULT_MANU_ENGINE)
            .codeStand(DEFAULT_CODE_STAND)
            .fluida(DEFAULT_FLUIDA)
            .flowRate(DEFAULT_FLOW_RATE)
            .pressureIn(DEFAULT_PRESSURE_IN)
            .pressureOut(DEFAULT_PRESSURE_OUT)
            .temperature(DEFAULT_TEMPERATURE)
            .basePressure(DEFAULT_BASE_PRESSURE)
            .baseTemperature(DEFAULT_BASE_TEMPERATURE)
            .inspection(DEFAULT_INSPECTION)
            .expired(DEFAULT_EXPIRED)
            .coiNumber(DEFAULT_COI_NUMBER)
            .coiDoc(DEFAULT_COI_DOC)
            .coiReport(DEFAULT_COI_REPORT)
            .reEngRla(DEFAULT_RE_ENG_RLA)
            .file(DEFAULT_FILE)
            .fileContentType(DEFAULT_FILE_CONTENT_TYPE);
        // Add required entity
        Area area;
        if (TestUtil.findAll(em, Area.class).isEmpty()) {
            area = AreaResourceIT.createEntity(em);
            em.persist(area);
            em.flush();
        } else {
            area = TestUtil.findAll(em, Area.class).get(0);
        }
        customer.setArea(area);
        return customer;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createUpdatedEntity(EntityManager em) {
        Customer customer = new Customer()
            .objectId(UPDATED_OBJECT_ID)
            .yCoordinate(UPDATED_Y_COORDINATE)
            .xCoordinate(UPDATED_X_COORDINATE)
            .refId(UPDATED_REF_ID)
            .tagId(UPDATED_TAG_ID)
            .name(UPDATED_NAME)
            .pipeName(UPDATED_PIPE_NAME)
            .yearInstalled(UPDATED_YEAR_INSTALLED)
            .owner(UPDATED_OWNER)
            .stationType(UPDATED_STATION_TYPE)
            .lineStream(UPDATED_LINE_STREAM)
            .customerType(UPDATED_CUSTOMER_TYPE)
            .identification(UPDATED_IDENTIFICATION)
            .equipment(UPDATED_EQUIPMENT)
            .type(UPDATED_TYPE)
            .manuMeter(UPDATED_MANU_METER)
            .manuFilter(UPDATED_MANU_FILTER)
            .manuEngine(UPDATED_MANU_ENGINE)
            .codeStand(UPDATED_CODE_STAND)
            .fluida(UPDATED_FLUIDA)
            .flowRate(UPDATED_FLOW_RATE)
            .pressureIn(UPDATED_PRESSURE_IN)
            .pressureOut(UPDATED_PRESSURE_OUT)
            .temperature(UPDATED_TEMPERATURE)
            .basePressure(UPDATED_BASE_PRESSURE)
            .baseTemperature(UPDATED_BASE_TEMPERATURE)
            .inspection(UPDATED_INSPECTION)
            .expired(UPDATED_EXPIRED)
            .coiNumber(UPDATED_COI_NUMBER)
            .coiDoc(UPDATED_COI_DOC)
            .coiReport(UPDATED_COI_REPORT)
            .reEngRla(UPDATED_RE_ENG_RLA)
            .file(UPDATED_FILE)
            .fileContentType(UPDATED_FILE_CONTENT_TYPE);
        // Add required entity
        Area area;
        if (TestUtil.findAll(em, Area.class).isEmpty()) {
            area = AreaResourceIT.createUpdatedEntity(em);
            em.persist(area);
            em.flush();
        } else {
            area = TestUtil.findAll(em, Area.class).get(0);
        }
        customer.setArea(area);
        return customer;
    }

    @BeforeEach
    public void initTest() {
        customer = createEntity(em);
    }

    @Test
    @Transactional
    public void createCustomer() throws Exception {
        int databaseSizeBeforeCreate = customerRepository.findAll().size();
        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);
        restCustomerMockMvc
            .perform(post("/api/customers").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customerDTO)))
            .andExpect(status().isCreated());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeCreate + 1);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getObjectId()).isEqualTo(DEFAULT_OBJECT_ID);
        assertThat(testCustomer.getyCoordinate()).isEqualTo(DEFAULT_Y_COORDINATE);
        assertThat(testCustomer.getxCoordinate()).isEqualTo(DEFAULT_X_COORDINATE);
        assertThat(testCustomer.getRefId()).isEqualTo(DEFAULT_REF_ID);
        assertThat(testCustomer.getTagId()).isEqualTo(DEFAULT_TAG_ID);
        assertThat(testCustomer.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testCustomer.getPipeName()).isEqualTo(DEFAULT_PIPE_NAME);
        assertThat(testCustomer.getYearInstalled()).isEqualTo(DEFAULT_YEAR_INSTALLED);
        assertThat(testCustomer.getOwner()).isEqualTo(DEFAULT_OWNER);
        assertThat(testCustomer.getStationType()).isEqualTo(DEFAULT_STATION_TYPE);
        assertThat(testCustomer.getLineStream()).isEqualTo(DEFAULT_LINE_STREAM);
        assertThat(testCustomer.getCustomerType()).isEqualTo(DEFAULT_CUSTOMER_TYPE);
        assertThat(testCustomer.getIdentification()).isEqualTo(DEFAULT_IDENTIFICATION);
        assertThat(testCustomer.getEquipment()).isEqualTo(DEFAULT_EQUIPMENT);
        assertThat(testCustomer.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testCustomer.getManuMeter()).isEqualTo(DEFAULT_MANU_METER);
        assertThat(testCustomer.getManuFilter()).isEqualTo(DEFAULT_MANU_FILTER);
        assertThat(testCustomer.getManuEngine()).isEqualTo(DEFAULT_MANU_ENGINE);
        assertThat(testCustomer.getCodeStand()).isEqualTo(DEFAULT_CODE_STAND);
        assertThat(testCustomer.getFluida()).isEqualTo(DEFAULT_FLUIDA);
        assertThat(testCustomer.getFlowRate()).isEqualTo(DEFAULT_FLOW_RATE);
        assertThat(testCustomer.getPressureIn()).isEqualTo(DEFAULT_PRESSURE_IN);
        assertThat(testCustomer.getPressureOut()).isEqualTo(DEFAULT_PRESSURE_OUT);
        assertThat(testCustomer.getTemperature()).isEqualTo(DEFAULT_TEMPERATURE);
        assertThat(testCustomer.getBasePressure()).isEqualTo(DEFAULT_BASE_PRESSURE);
        assertThat(testCustomer.getBaseTemperature()).isEqualTo(DEFAULT_BASE_TEMPERATURE);
        assertThat(testCustomer.getInspection()).isEqualTo(DEFAULT_INSPECTION);
        assertThat(testCustomer.getExpired()).isEqualTo(DEFAULT_EXPIRED);
        assertThat(testCustomer.getCoiNumber()).isEqualTo(DEFAULT_COI_NUMBER);
        assertThat(testCustomer.getCoiDoc()).isEqualTo(DEFAULT_COI_DOC);
        assertThat(testCustomer.getCoiReport()).isEqualTo(DEFAULT_COI_REPORT);
        assertThat(testCustomer.getReEngRla()).isEqualTo(DEFAULT_RE_ENG_RLA);
        assertThat(testCustomer.getFile()).isEqualTo(DEFAULT_FILE);
        assertThat(testCustomer.getFileContentType()).isEqualTo(DEFAULT_FILE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createCustomerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = customerRepository.findAll().size();

        // Create the Customer with an existing ID
        customer.setId(1L);
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCustomerMockMvc
            .perform(post("/api/customers").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCustomers() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        // Get all the customerList
        restCustomerMockMvc
            .perform(get("/api/customers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(customer.getId().intValue())))
            .andExpect(jsonPath("$.[*].objectId").value(hasItem(DEFAULT_OBJECT_ID.intValue())))
            .andExpect(jsonPath("$.[*].yCoordinate").value(hasItem(DEFAULT_Y_COORDINATE.doubleValue())))
            .andExpect(jsonPath("$.[*].xCoordinate").value(hasItem(DEFAULT_X_COORDINATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refId").value(hasItem(DEFAULT_REF_ID)))
            .andExpect(jsonPath("$.[*].tagId").value(hasItem(DEFAULT_TAG_ID)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].pipeName").value(hasItem(DEFAULT_PIPE_NAME)))
            .andExpect(jsonPath("$.[*].yearInstalled").value(hasItem(DEFAULT_YEAR_INSTALLED)))
            .andExpect(jsonPath("$.[*].owner").value(hasItem(DEFAULT_OWNER)))
            .andExpect(jsonPath("$.[*].stationType").value(hasItem(DEFAULT_STATION_TYPE)))
            .andExpect(jsonPath("$.[*].lineStream").value(hasItem(DEFAULT_LINE_STREAM)))
            .andExpect(jsonPath("$.[*].customerType").value(hasItem(DEFAULT_CUSTOMER_TYPE)))
            .andExpect(jsonPath("$.[*].identification").value(hasItem(DEFAULT_IDENTIFICATION)))
            .andExpect(jsonPath("$.[*].equipment").value(hasItem(DEFAULT_EQUIPMENT)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].manuMeter").value(hasItem(DEFAULT_MANU_METER)))
            .andExpect(jsonPath("$.[*].manuFilter").value(hasItem(DEFAULT_MANU_FILTER)))
            .andExpect(jsonPath("$.[*].manuEngine").value(hasItem(DEFAULT_MANU_ENGINE)))
            .andExpect(jsonPath("$.[*].codeStand").value(hasItem(DEFAULT_CODE_STAND)))
            .andExpect(jsonPath("$.[*].fluida").value(hasItem(DEFAULT_FLUIDA)))
            .andExpect(jsonPath("$.[*].flowRate").value(hasItem(DEFAULT_FLOW_RATE)))
            .andExpect(jsonPath("$.[*].pressureIn").value(hasItem(DEFAULT_PRESSURE_IN)))
            .andExpect(jsonPath("$.[*].pressureOut").value(hasItem(DEFAULT_PRESSURE_OUT)))
            .andExpect(jsonPath("$.[*].temperature").value(hasItem(DEFAULT_TEMPERATURE)))
            .andExpect(jsonPath("$.[*].basePressure").value(hasItem(DEFAULT_BASE_PRESSURE)))
            .andExpect(jsonPath("$.[*].baseTemperature").value(hasItem(DEFAULT_BASE_TEMPERATURE)))
            .andExpect(jsonPath("$.[*].inspection").value(hasItem(DEFAULT_INSPECTION.toString())))
            .andExpect(jsonPath("$.[*].expired").value(hasItem(DEFAULT_EXPIRED.toString())))
            .andExpect(jsonPath("$.[*].coiNumber").value(hasItem(DEFAULT_COI_NUMBER)))
            .andExpect(jsonPath("$.[*].coiDoc").value(hasItem(DEFAULT_COI_DOC)))
            .andExpect(jsonPath("$.[*].coiReport").value(hasItem(DEFAULT_COI_REPORT)))
            .andExpect(jsonPath("$.[*].reEngRla").value(hasItem(DEFAULT_RE_ENG_RLA)))
            .andExpect(jsonPath("$.[*].fileContentType").value(hasItem(DEFAULT_FILE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].file").value(hasItem(Base64Utils.encodeToString(DEFAULT_FILE))));
    }

    @Test
    @Transactional
    public void getCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        // Get the customer
        restCustomerMockMvc
            .perform(get("/api/customers/{id}", customer.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(customer.getId().intValue()))
            .andExpect(jsonPath("$.objectId").value(DEFAULT_OBJECT_ID.intValue()))
            .andExpect(jsonPath("$.yCoordinate").value(DEFAULT_Y_COORDINATE.doubleValue()))
            .andExpect(jsonPath("$.xCoordinate").value(DEFAULT_X_COORDINATE.doubleValue()))
            .andExpect(jsonPath("$.refId").value(DEFAULT_REF_ID))
            .andExpect(jsonPath("$.tagId").value(DEFAULT_TAG_ID))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.pipeName").value(DEFAULT_PIPE_NAME))
            .andExpect(jsonPath("$.yearInstalled").value(DEFAULT_YEAR_INSTALLED))
            .andExpect(jsonPath("$.owner").value(DEFAULT_OWNER))
            .andExpect(jsonPath("$.stationType").value(DEFAULT_STATION_TYPE))
            .andExpect(jsonPath("$.lineStream").value(DEFAULT_LINE_STREAM))
            .andExpect(jsonPath("$.customerType").value(DEFAULT_CUSTOMER_TYPE))
            .andExpect(jsonPath("$.identification").value(DEFAULT_IDENTIFICATION))
            .andExpect(jsonPath("$.equipment").value(DEFAULT_EQUIPMENT))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.manuMeter").value(DEFAULT_MANU_METER))
            .andExpect(jsonPath("$.manuFilter").value(DEFAULT_MANU_FILTER))
            .andExpect(jsonPath("$.manuEngine").value(DEFAULT_MANU_ENGINE))
            .andExpect(jsonPath("$.codeStand").value(DEFAULT_CODE_STAND))
            .andExpect(jsonPath("$.fluida").value(DEFAULT_FLUIDA))
            .andExpect(jsonPath("$.flowRate").value(DEFAULT_FLOW_RATE))
            .andExpect(jsonPath("$.pressureIn").value(DEFAULT_PRESSURE_IN))
            .andExpect(jsonPath("$.pressureOut").value(DEFAULT_PRESSURE_OUT))
            .andExpect(jsonPath("$.temperature").value(DEFAULT_TEMPERATURE))
            .andExpect(jsonPath("$.basePressure").value(DEFAULT_BASE_PRESSURE))
            .andExpect(jsonPath("$.baseTemperature").value(DEFAULT_BASE_TEMPERATURE))
            .andExpect(jsonPath("$.inspection").value(DEFAULT_INSPECTION.toString()))
            .andExpect(jsonPath("$.expired").value(DEFAULT_EXPIRED.toString()))
            .andExpect(jsonPath("$.coiNumber").value(DEFAULT_COI_NUMBER))
            .andExpect(jsonPath("$.coiDoc").value(DEFAULT_COI_DOC))
            .andExpect(jsonPath("$.coiReport").value(DEFAULT_COI_REPORT))
            .andExpect(jsonPath("$.reEngRla").value(DEFAULT_RE_ENG_RLA))
            .andExpect(jsonPath("$.fileContentType").value(DEFAULT_FILE_CONTENT_TYPE))
            .andExpect(jsonPath("$.file").value(Base64Utils.encodeToString(DEFAULT_FILE)));
    }

    @Test
    @Transactional
    public void getNonExistingCustomer() throws Exception {
        // Get the customer
        restCustomerMockMvc.perform(get("/api/customers/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Update the customer
        Customer updatedCustomer = customerRepository.findById(customer.getId()).get();
        // Disconnect from session so that the updates on updatedCustomer are not directly saved in db
        em.detach(updatedCustomer);
        updatedCustomer
            .objectId(UPDATED_OBJECT_ID)
            .yCoordinate(UPDATED_Y_COORDINATE)
            .xCoordinate(UPDATED_X_COORDINATE)
            .refId(UPDATED_REF_ID)
            .tagId(UPDATED_TAG_ID)
            .name(UPDATED_NAME)
            .pipeName(UPDATED_PIPE_NAME)
            .yearInstalled(UPDATED_YEAR_INSTALLED)
            .owner(UPDATED_OWNER)
            .stationType(UPDATED_STATION_TYPE)
            .lineStream(UPDATED_LINE_STREAM)
            .customerType(UPDATED_CUSTOMER_TYPE)
            .identification(UPDATED_IDENTIFICATION)
            .equipment(UPDATED_EQUIPMENT)
            .type(UPDATED_TYPE)
            .manuMeter(UPDATED_MANU_METER)
            .manuFilter(UPDATED_MANU_FILTER)
            .manuEngine(UPDATED_MANU_ENGINE)
            .codeStand(UPDATED_CODE_STAND)
            .fluida(UPDATED_FLUIDA)
            .flowRate(UPDATED_FLOW_RATE)
            .pressureIn(UPDATED_PRESSURE_IN)
            .pressureOut(UPDATED_PRESSURE_OUT)
            .temperature(UPDATED_TEMPERATURE)
            .basePressure(UPDATED_BASE_PRESSURE)
            .baseTemperature(UPDATED_BASE_TEMPERATURE)
            .inspection(UPDATED_INSPECTION)
            .expired(UPDATED_EXPIRED)
            .coiNumber(UPDATED_COI_NUMBER)
            .coiDoc(UPDATED_COI_DOC)
            .coiReport(UPDATED_COI_REPORT)
            .reEngRla(UPDATED_RE_ENG_RLA)
            .file(UPDATED_FILE)
            .fileContentType(UPDATED_FILE_CONTENT_TYPE);
        CustomerDTO customerDTO = customerMapper.toDto(updatedCustomer);

        restCustomerMockMvc
            .perform(put("/api/customers").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customerDTO)))
            .andExpect(status().isOk());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getObjectId()).isEqualTo(UPDATED_OBJECT_ID);
        assertThat(testCustomer.getyCoordinate()).isEqualTo(UPDATED_Y_COORDINATE);
        assertThat(testCustomer.getxCoordinate()).isEqualTo(UPDATED_X_COORDINATE);
        assertThat(testCustomer.getRefId()).isEqualTo(UPDATED_REF_ID);
        assertThat(testCustomer.getTagId()).isEqualTo(UPDATED_TAG_ID);
        assertThat(testCustomer.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testCustomer.getPipeName()).isEqualTo(UPDATED_PIPE_NAME);
        assertThat(testCustomer.getYearInstalled()).isEqualTo(UPDATED_YEAR_INSTALLED);
        assertThat(testCustomer.getOwner()).isEqualTo(UPDATED_OWNER);
        assertThat(testCustomer.getStationType()).isEqualTo(UPDATED_STATION_TYPE);
        assertThat(testCustomer.getLineStream()).isEqualTo(UPDATED_LINE_STREAM);
        assertThat(testCustomer.getCustomerType()).isEqualTo(UPDATED_CUSTOMER_TYPE);
        assertThat(testCustomer.getIdentification()).isEqualTo(UPDATED_IDENTIFICATION);
        assertThat(testCustomer.getEquipment()).isEqualTo(UPDATED_EQUIPMENT);
        assertThat(testCustomer.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testCustomer.getManuMeter()).isEqualTo(UPDATED_MANU_METER);
        assertThat(testCustomer.getManuFilter()).isEqualTo(UPDATED_MANU_FILTER);
        assertThat(testCustomer.getManuEngine()).isEqualTo(UPDATED_MANU_ENGINE);
        assertThat(testCustomer.getCodeStand()).isEqualTo(UPDATED_CODE_STAND);
        assertThat(testCustomer.getFluida()).isEqualTo(UPDATED_FLUIDA);
        assertThat(testCustomer.getFlowRate()).isEqualTo(UPDATED_FLOW_RATE);
        assertThat(testCustomer.getPressureIn()).isEqualTo(UPDATED_PRESSURE_IN);
        assertThat(testCustomer.getPressureOut()).isEqualTo(UPDATED_PRESSURE_OUT);
        assertThat(testCustomer.getTemperature()).isEqualTo(UPDATED_TEMPERATURE);
        assertThat(testCustomer.getBasePressure()).isEqualTo(UPDATED_BASE_PRESSURE);
        assertThat(testCustomer.getBaseTemperature()).isEqualTo(UPDATED_BASE_TEMPERATURE);
        assertThat(testCustomer.getInspection()).isEqualTo(UPDATED_INSPECTION);
        assertThat(testCustomer.getExpired()).isEqualTo(UPDATED_EXPIRED);
        assertThat(testCustomer.getCoiNumber()).isEqualTo(UPDATED_COI_NUMBER);
        assertThat(testCustomer.getCoiDoc()).isEqualTo(UPDATED_COI_DOC);
        assertThat(testCustomer.getCoiReport()).isEqualTo(UPDATED_COI_REPORT);
        assertThat(testCustomer.getReEngRla()).isEqualTo(UPDATED_RE_ENG_RLA);
        assertThat(testCustomer.getFile()).isEqualTo(UPDATED_FILE);
        assertThat(testCustomer.getFileContentType()).isEqualTo(UPDATED_FILE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(put("/api/customers").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeDelete = customerRepository.findAll().size();

        // Delete the customer
        restCustomerMockMvc
            .perform(delete("/api/customers/{id}", customer.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
