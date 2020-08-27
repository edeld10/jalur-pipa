package id.doddee.jalurpipa.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import id.doddee.jalurpipa.JalurpipaApp;
import id.doddee.jalurpipa.RedisTestContainerExtension;
import id.doddee.jalurpipa.domain.Area;
import id.doddee.jalurpipa.domain.Pipe;
import id.doddee.jalurpipa.repository.PipeRepository;
import id.doddee.jalurpipa.service.PipeService;
import id.doddee.jalurpipa.service.dto.PipeDTO;
import id.doddee.jalurpipa.service.mapper.PipeMapper;
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
 * Integration tests for the {@link PipeResource} REST controller.
 */
@SpringBootTest(classes = JalurpipaApp.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class PipeResourceIT {
    private static final Long DEFAULT_OBJECT_ID = 1L;
    private static final Long UPDATED_OBJECT_ID = 2L;

    private static final Double DEFAULT_Y_START_COORDINATE = 1D;
    private static final Double UPDATED_Y_START_COORDINATE = 2D;

    private static final Double DEFAULT_X_START_COORDINATE = 1D;
    private static final Double UPDATED_X_START_COORDINATE = 2D;

    private static final Double DEFAULT_Y_END_COORDINATE = 1D;
    private static final Double UPDATED_Y_END_COORDINATE = 2D;

    private static final Double DEFAULT_X_END_COORDINATE = 1D;
    private static final Double UPDATED_X_END_COORDINATE = 2D;

    private static final String DEFAULT_TAG_ID = "AAAAAAAAAA";
    private static final String UPDATED_TAG_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PIPE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PIPE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_DIAMETER = 1;
    private static final Integer UPDATED_DIAMETER = 2;

    private static final String DEFAULT_DIAMETER_UN = "AAAAAAAAAA";
    private static final String UPDATED_DIAMETER_UN = "BBBBBBBBBB";

    private static final String DEFAULT_MATERIAL = "AAAAAAAAAA";
    private static final String UPDATED_MATERIAL = "BBBBBBBBBB";

    private static final String DEFAULT_OPERATION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_OPERATION_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CONSTRUCTION_YEAR = 1;
    private static final Integer UPDATED_CONSTRUCTION_YEAR = 2;

    private static final Integer DEFAULT_P_1_LENGTH = 1;
    private static final Integer UPDATED_P_1_LENGTH = 2;

    private static final Integer DEFAULT_ACTUAL_LENGTH = 1;
    private static final Integer UPDATED_ACTUAL_LENGTH = 2;

    private static final String DEFAULT_COMPARISON_STANDARD = "AAAAAAAAAA";
    private static final String UPDATED_COMPARISON_STANDARD = "BBBBBBBBBB";

    private static final Integer DEFAULT_LOK_CLASS = 1;
    private static final Integer UPDATED_LOK_CLASS = 2;

    private static final String DEFAULT_PIPE_MATERIAL = "AAAAAAAAAA";
    private static final String UPDATED_PIPE_MATERIAL = "BBBBBBBBBB";

    private static final String DEFAULT_PEN_TOOLS = "AAAAAAAAAA";
    private static final String UPDATED_PEN_TOOLS = "BBBBBBBBBB";

    private static final String DEFAULT_ROW = "AAAAAAAAAA";
    private static final String UPDATED_ROW = "BBBBBBBBBB";

    private static final String DEFAULT_MAOP_DP = "AAAAAAAAAA";
    private static final String UPDATED_MAOP_DP = "BBBBBBBBBB";

    private static final String DEFAULT_MAX_TEMPERATURE = "AAAAAAAAAA";
    private static final String UPDATED_MAX_TEMPERATURE = "BBBBBBBBBB";

    private static final String DEFAULT_PLO_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PLO_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_COI_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_COI_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_RA_PIPE = "AAAAAAAAAA";
    private static final String UPDATED_RA_PIPE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INSPECTION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSPECTION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_EXPIRED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXPIRED = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_MODIFIED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_MODIFIED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_PLO_DOCUMENT = "AAAAAAAAAA";
    private static final String UPDATED_PLO_DOCUMENT = "BBBBBBBBBB";

    private static final String DEFAULT_PLO_REPORT = "AAAAAAAAAA";
    private static final String UPDATED_PLO_REPORT = "BBBBBBBBBB";

    private static final String DEFAULT_COI_DOCUMENT = "AAAAAAAAAA";
    private static final String UPDATED_COI_DOCUMENT = "BBBBBBBBBB";

    private static final String DEFAULT_RA_DOCUMENT = "AAAAAAAAAA";
    private static final String UPDATED_RA_DOCUMENT = "BBBBBBBBBB";

    private static final byte[] DEFAULT_FILE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_FILE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_FILE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_FILE_CONTENT_TYPE = "image/png";

    @Autowired
    private PipeRepository pipeRepository;

    @Autowired
    private PipeMapper pipeMapper;

    @Autowired
    private PipeService pipeService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPipeMockMvc;

    private Pipe pipe;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Pipe createEntity(EntityManager em) {
        Pipe pipe = new Pipe()
            .objectId(DEFAULT_OBJECT_ID)
            .yStartCoordinate(DEFAULT_Y_START_COORDINATE)
            .xStartCoordinate(DEFAULT_X_START_COORDINATE)
            .yEndCoordinate(DEFAULT_Y_END_COORDINATE)
            .xEndCoordinate(DEFAULT_X_END_COORDINATE)
            .tagId(DEFAULT_TAG_ID)
            .pipeName(DEFAULT_PIPE_NAME)
            .description(DEFAULT_DESCRIPTION)
            .diameter(DEFAULT_DIAMETER)
            .diameterUn(DEFAULT_DIAMETER_UN)
            .material(DEFAULT_MATERIAL)
            .operationType(DEFAULT_OPERATION_TYPE)
            .constructionYear(DEFAULT_CONSTRUCTION_YEAR)
            .p1Length(DEFAULT_P_1_LENGTH)
            .actualLength(DEFAULT_ACTUAL_LENGTH)
            .comparisonStandard(DEFAULT_COMPARISON_STANDARD)
            .lokClass(DEFAULT_LOK_CLASS)
            .pipeMaterial(DEFAULT_PIPE_MATERIAL)
            .penTools(DEFAULT_PEN_TOOLS)
            .row(DEFAULT_ROW)
            .maopDp(DEFAULT_MAOP_DP)
            .maxTemperature(DEFAULT_MAX_TEMPERATURE)
            .ploNumber(DEFAULT_PLO_NUMBER)
            .coiNumber(DEFAULT_COI_NUMBER)
            .raPipe(DEFAULT_RA_PIPE)
            .inspection(DEFAULT_INSPECTION)
            .expired(DEFAULT_EXPIRED)
            .modified(DEFAULT_MODIFIED)
            .ploDocument(DEFAULT_PLO_DOCUMENT)
            .ploReport(DEFAULT_PLO_REPORT)
            .coiDocument(DEFAULT_COI_DOCUMENT)
            .raDocument(DEFAULT_RA_DOCUMENT)
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
        pipe.setArea(area);
        return pipe;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Pipe createUpdatedEntity(EntityManager em) {
        Pipe pipe = new Pipe()
            .objectId(UPDATED_OBJECT_ID)
            .yStartCoordinate(UPDATED_Y_START_COORDINATE)
            .xStartCoordinate(UPDATED_X_START_COORDINATE)
            .yEndCoordinate(UPDATED_Y_END_COORDINATE)
            .xEndCoordinate(UPDATED_X_END_COORDINATE)
            .tagId(UPDATED_TAG_ID)
            .pipeName(UPDATED_PIPE_NAME)
            .description(UPDATED_DESCRIPTION)
            .diameter(UPDATED_DIAMETER)
            .diameterUn(UPDATED_DIAMETER_UN)
            .material(UPDATED_MATERIAL)
            .operationType(UPDATED_OPERATION_TYPE)
            .constructionYear(UPDATED_CONSTRUCTION_YEAR)
            .p1Length(UPDATED_P_1_LENGTH)
            .actualLength(UPDATED_ACTUAL_LENGTH)
            .comparisonStandard(UPDATED_COMPARISON_STANDARD)
            .lokClass(UPDATED_LOK_CLASS)
            .pipeMaterial(UPDATED_PIPE_MATERIAL)
            .penTools(UPDATED_PEN_TOOLS)
            .row(UPDATED_ROW)
            .maopDp(UPDATED_MAOP_DP)
            .maxTemperature(UPDATED_MAX_TEMPERATURE)
            .ploNumber(UPDATED_PLO_NUMBER)
            .coiNumber(UPDATED_COI_NUMBER)
            .raPipe(UPDATED_RA_PIPE)
            .inspection(UPDATED_INSPECTION)
            .expired(UPDATED_EXPIRED)
            .modified(UPDATED_MODIFIED)
            .ploDocument(UPDATED_PLO_DOCUMENT)
            .ploReport(UPDATED_PLO_REPORT)
            .coiDocument(UPDATED_COI_DOCUMENT)
            .raDocument(UPDATED_RA_DOCUMENT)
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
        pipe.setArea(area);
        return pipe;
    }

    @BeforeEach
    public void initTest() {
        pipe = createEntity(em);
    }

    @Test
    @Transactional
    public void createPipe() throws Exception {
        int databaseSizeBeforeCreate = pipeRepository.findAll().size();
        // Create the Pipe
        PipeDTO pipeDTO = pipeMapper.toDto(pipe);
        restPipeMockMvc
            .perform(post("/api/pipes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pipeDTO)))
            .andExpect(status().isCreated());

        // Validate the Pipe in the database
        List<Pipe> pipeList = pipeRepository.findAll();
        assertThat(pipeList).hasSize(databaseSizeBeforeCreate + 1);
        Pipe testPipe = pipeList.get(pipeList.size() - 1);
        assertThat(testPipe.getObjectId()).isEqualTo(DEFAULT_OBJECT_ID);
        assertThat(testPipe.getyStartCoordinate()).isEqualTo(DEFAULT_Y_START_COORDINATE);
        assertThat(testPipe.getxStartCoordinate()).isEqualTo(DEFAULT_X_START_COORDINATE);
        assertThat(testPipe.getyEndCoordinate()).isEqualTo(DEFAULT_Y_END_COORDINATE);
        assertThat(testPipe.getxEndCoordinate()).isEqualTo(DEFAULT_X_END_COORDINATE);
        assertThat(testPipe.getTagId()).isEqualTo(DEFAULT_TAG_ID);
        assertThat(testPipe.getPipeName()).isEqualTo(DEFAULT_PIPE_NAME);
        assertThat(testPipe.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testPipe.getDiameter()).isEqualTo(DEFAULT_DIAMETER);
        assertThat(testPipe.getDiameterUn()).isEqualTo(DEFAULT_DIAMETER_UN);
        assertThat(testPipe.getMaterial()).isEqualTo(DEFAULT_MATERIAL);
        assertThat(testPipe.getOperationType()).isEqualTo(DEFAULT_OPERATION_TYPE);
        assertThat(testPipe.getConstructionYear()).isEqualTo(DEFAULT_CONSTRUCTION_YEAR);
        assertThat(testPipe.getp1Length()).isEqualTo(DEFAULT_P_1_LENGTH);
        assertThat(testPipe.getActualLength()).isEqualTo(DEFAULT_ACTUAL_LENGTH);
        assertThat(testPipe.getComparisonStandard()).isEqualTo(DEFAULT_COMPARISON_STANDARD);
        assertThat(testPipe.getLokClass()).isEqualTo(DEFAULT_LOK_CLASS);
        assertThat(testPipe.getPipeMaterial()).isEqualTo(DEFAULT_PIPE_MATERIAL);
        assertThat(testPipe.getPenTools()).isEqualTo(DEFAULT_PEN_TOOLS);
        assertThat(testPipe.getRow()).isEqualTo(DEFAULT_ROW);
        assertThat(testPipe.getMaopDp()).isEqualTo(DEFAULT_MAOP_DP);
        assertThat(testPipe.getMaxTemperature()).isEqualTo(DEFAULT_MAX_TEMPERATURE);
        assertThat(testPipe.getPloNumber()).isEqualTo(DEFAULT_PLO_NUMBER);
        assertThat(testPipe.getCoiNumber()).isEqualTo(DEFAULT_COI_NUMBER);
        assertThat(testPipe.getRaPipe()).isEqualTo(DEFAULT_RA_PIPE);
        assertThat(testPipe.getInspection()).isEqualTo(DEFAULT_INSPECTION);
        assertThat(testPipe.getExpired()).isEqualTo(DEFAULT_EXPIRED);
        assertThat(testPipe.getModified()).isEqualTo(DEFAULT_MODIFIED);
        assertThat(testPipe.getPloDocument()).isEqualTo(DEFAULT_PLO_DOCUMENT);
        assertThat(testPipe.getPloReport()).isEqualTo(DEFAULT_PLO_REPORT);
        assertThat(testPipe.getCoiDocument()).isEqualTo(DEFAULT_COI_DOCUMENT);
        assertThat(testPipe.getRaDocument()).isEqualTo(DEFAULT_RA_DOCUMENT);
        assertThat(testPipe.getFile()).isEqualTo(DEFAULT_FILE);
        assertThat(testPipe.getFileContentType()).isEqualTo(DEFAULT_FILE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createPipeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = pipeRepository.findAll().size();

        // Create the Pipe with an existing ID
        pipe.setId(1L);
        PipeDTO pipeDTO = pipeMapper.toDto(pipe);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPipeMockMvc
            .perform(post("/api/pipes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pipeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Pipe in the database
        List<Pipe> pipeList = pipeRepository.findAll();
        assertThat(pipeList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllPipes() throws Exception {
        // Initialize the database
        pipeRepository.saveAndFlush(pipe);

        // Get all the pipeList
        restPipeMockMvc
            .perform(get("/api/pipes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(pipe.getId().intValue())))
            .andExpect(jsonPath("$.[*].objectId").value(hasItem(DEFAULT_OBJECT_ID.intValue())))
            .andExpect(jsonPath("$.[*].yStartCoordinate").value(hasItem(DEFAULT_Y_START_COORDINATE.doubleValue())))
            .andExpect(jsonPath("$.[*].xStartCoordinate").value(hasItem(DEFAULT_X_START_COORDINATE.doubleValue())))
            .andExpect(jsonPath("$.[*].yEndCoordinate").value(hasItem(DEFAULT_Y_END_COORDINATE.doubleValue())))
            .andExpect(jsonPath("$.[*].xEndCoordinate").value(hasItem(DEFAULT_X_END_COORDINATE.doubleValue())))
            .andExpect(jsonPath("$.[*].tagId").value(hasItem(DEFAULT_TAG_ID)))
            .andExpect(jsonPath("$.[*].pipeName").value(hasItem(DEFAULT_PIPE_NAME)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].diameter").value(hasItem(DEFAULT_DIAMETER)))
            .andExpect(jsonPath("$.[*].diameterUn").value(hasItem(DEFAULT_DIAMETER_UN)))
            .andExpect(jsonPath("$.[*].material").value(hasItem(DEFAULT_MATERIAL)))
            .andExpect(jsonPath("$.[*].operationType").value(hasItem(DEFAULT_OPERATION_TYPE)))
            .andExpect(jsonPath("$.[*].constructionYear").value(hasItem(DEFAULT_CONSTRUCTION_YEAR)))
            .andExpect(jsonPath("$.[*].p1Length").value(hasItem(DEFAULT_P_1_LENGTH)))
            .andExpect(jsonPath("$.[*].actualLength").value(hasItem(DEFAULT_ACTUAL_LENGTH)))
            .andExpect(jsonPath("$.[*].comparisonStandard").value(hasItem(DEFAULT_COMPARISON_STANDARD)))
            .andExpect(jsonPath("$.[*].lokClass").value(hasItem(DEFAULT_LOK_CLASS)))
            .andExpect(jsonPath("$.[*].pipeMaterial").value(hasItem(DEFAULT_PIPE_MATERIAL)))
            .andExpect(jsonPath("$.[*].penTools").value(hasItem(DEFAULT_PEN_TOOLS)))
            .andExpect(jsonPath("$.[*].row").value(hasItem(DEFAULT_ROW)))
            .andExpect(jsonPath("$.[*].maopDp").value(hasItem(DEFAULT_MAOP_DP)))
            .andExpect(jsonPath("$.[*].maxTemperature").value(hasItem(DEFAULT_MAX_TEMPERATURE)))
            .andExpect(jsonPath("$.[*].ploNumber").value(hasItem(DEFAULT_PLO_NUMBER)))
            .andExpect(jsonPath("$.[*].coiNumber").value(hasItem(DEFAULT_COI_NUMBER)))
            .andExpect(jsonPath("$.[*].raPipe").value(hasItem(DEFAULT_RA_PIPE)))
            .andExpect(jsonPath("$.[*].inspection").value(hasItem(DEFAULT_INSPECTION.toString())))
            .andExpect(jsonPath("$.[*].expired").value(hasItem(DEFAULT_EXPIRED.toString())))
            .andExpect(jsonPath("$.[*].modified").value(hasItem(DEFAULT_MODIFIED.toString())))
            .andExpect(jsonPath("$.[*].ploDocument").value(hasItem(DEFAULT_PLO_DOCUMENT)))
            .andExpect(jsonPath("$.[*].ploReport").value(hasItem(DEFAULT_PLO_REPORT)))
            .andExpect(jsonPath("$.[*].coiDocument").value(hasItem(DEFAULT_COI_DOCUMENT)))
            .andExpect(jsonPath("$.[*].raDocument").value(hasItem(DEFAULT_RA_DOCUMENT)))
            .andExpect(jsonPath("$.[*].fileContentType").value(hasItem(DEFAULT_FILE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].file").value(hasItem(Base64Utils.encodeToString(DEFAULT_FILE))));
    }

    @Test
    @Transactional
    public void getPipe() throws Exception {
        // Initialize the database
        pipeRepository.saveAndFlush(pipe);

        // Get the pipe
        restPipeMockMvc
            .perform(get("/api/pipes/{id}", pipe.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(pipe.getId().intValue()))
            .andExpect(jsonPath("$.objectId").value(DEFAULT_OBJECT_ID.intValue()))
            .andExpect(jsonPath("$.yStartCoordinate").value(DEFAULT_Y_START_COORDINATE.doubleValue()))
            .andExpect(jsonPath("$.xStartCoordinate").value(DEFAULT_X_START_COORDINATE.doubleValue()))
            .andExpect(jsonPath("$.yEndCoordinate").value(DEFAULT_Y_END_COORDINATE.doubleValue()))
            .andExpect(jsonPath("$.xEndCoordinate").value(DEFAULT_X_END_COORDINATE.doubleValue()))
            .andExpect(jsonPath("$.tagId").value(DEFAULT_TAG_ID))
            .andExpect(jsonPath("$.pipeName").value(DEFAULT_PIPE_NAME))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.diameter").value(DEFAULT_DIAMETER))
            .andExpect(jsonPath("$.diameterUn").value(DEFAULT_DIAMETER_UN))
            .andExpect(jsonPath("$.material").value(DEFAULT_MATERIAL))
            .andExpect(jsonPath("$.operationType").value(DEFAULT_OPERATION_TYPE))
            .andExpect(jsonPath("$.constructionYear").value(DEFAULT_CONSTRUCTION_YEAR))
            .andExpect(jsonPath("$.p1Length").value(DEFAULT_P_1_LENGTH))
            .andExpect(jsonPath("$.actualLength").value(DEFAULT_ACTUAL_LENGTH))
            .andExpect(jsonPath("$.comparisonStandard").value(DEFAULT_COMPARISON_STANDARD))
            .andExpect(jsonPath("$.lokClass").value(DEFAULT_LOK_CLASS))
            .andExpect(jsonPath("$.pipeMaterial").value(DEFAULT_PIPE_MATERIAL))
            .andExpect(jsonPath("$.penTools").value(DEFAULT_PEN_TOOLS))
            .andExpect(jsonPath("$.row").value(DEFAULT_ROW))
            .andExpect(jsonPath("$.maopDp").value(DEFAULT_MAOP_DP))
            .andExpect(jsonPath("$.maxTemperature").value(DEFAULT_MAX_TEMPERATURE))
            .andExpect(jsonPath("$.ploNumber").value(DEFAULT_PLO_NUMBER))
            .andExpect(jsonPath("$.coiNumber").value(DEFAULT_COI_NUMBER))
            .andExpect(jsonPath("$.raPipe").value(DEFAULT_RA_PIPE))
            .andExpect(jsonPath("$.inspection").value(DEFAULT_INSPECTION.toString()))
            .andExpect(jsonPath("$.expired").value(DEFAULT_EXPIRED.toString()))
            .andExpect(jsonPath("$.modified").value(DEFAULT_MODIFIED.toString()))
            .andExpect(jsonPath("$.ploDocument").value(DEFAULT_PLO_DOCUMENT))
            .andExpect(jsonPath("$.ploReport").value(DEFAULT_PLO_REPORT))
            .andExpect(jsonPath("$.coiDocument").value(DEFAULT_COI_DOCUMENT))
            .andExpect(jsonPath("$.raDocument").value(DEFAULT_RA_DOCUMENT))
            .andExpect(jsonPath("$.fileContentType").value(DEFAULT_FILE_CONTENT_TYPE))
            .andExpect(jsonPath("$.file").value(Base64Utils.encodeToString(DEFAULT_FILE)));
    }

    @Test
    @Transactional
    public void getNonExistingPipe() throws Exception {
        // Get the pipe
        restPipeMockMvc.perform(get("/api/pipes/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePipe() throws Exception {
        // Initialize the database
        pipeRepository.saveAndFlush(pipe);

        int databaseSizeBeforeUpdate = pipeRepository.findAll().size();

        // Update the pipe
        Pipe updatedPipe = pipeRepository.findById(pipe.getId()).get();
        // Disconnect from session so that the updates on updatedPipe are not directly saved in db
        em.detach(updatedPipe);
        updatedPipe
            .objectId(UPDATED_OBJECT_ID)
            .yStartCoordinate(UPDATED_Y_START_COORDINATE)
            .xStartCoordinate(UPDATED_X_START_COORDINATE)
            .yEndCoordinate(UPDATED_Y_END_COORDINATE)
            .xEndCoordinate(UPDATED_X_END_COORDINATE)
            .tagId(UPDATED_TAG_ID)
            .pipeName(UPDATED_PIPE_NAME)
            .description(UPDATED_DESCRIPTION)
            .diameter(UPDATED_DIAMETER)
            .diameterUn(UPDATED_DIAMETER_UN)
            .material(UPDATED_MATERIAL)
            .operationType(UPDATED_OPERATION_TYPE)
            .constructionYear(UPDATED_CONSTRUCTION_YEAR)
            .p1Length(UPDATED_P_1_LENGTH)
            .actualLength(UPDATED_ACTUAL_LENGTH)
            .comparisonStandard(UPDATED_COMPARISON_STANDARD)
            .lokClass(UPDATED_LOK_CLASS)
            .pipeMaterial(UPDATED_PIPE_MATERIAL)
            .penTools(UPDATED_PEN_TOOLS)
            .row(UPDATED_ROW)
            .maopDp(UPDATED_MAOP_DP)
            .maxTemperature(UPDATED_MAX_TEMPERATURE)
            .ploNumber(UPDATED_PLO_NUMBER)
            .coiNumber(UPDATED_COI_NUMBER)
            .raPipe(UPDATED_RA_PIPE)
            .inspection(UPDATED_INSPECTION)
            .expired(UPDATED_EXPIRED)
            .modified(UPDATED_MODIFIED)
            .ploDocument(UPDATED_PLO_DOCUMENT)
            .ploReport(UPDATED_PLO_REPORT)
            .coiDocument(UPDATED_COI_DOCUMENT)
            .raDocument(UPDATED_RA_DOCUMENT)
            .file(UPDATED_FILE)
            .fileContentType(UPDATED_FILE_CONTENT_TYPE);
        PipeDTO pipeDTO = pipeMapper.toDto(updatedPipe);

        restPipeMockMvc
            .perform(put("/api/pipes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pipeDTO)))
            .andExpect(status().isOk());

        // Validate the Pipe in the database
        List<Pipe> pipeList = pipeRepository.findAll();
        assertThat(pipeList).hasSize(databaseSizeBeforeUpdate);
        Pipe testPipe = pipeList.get(pipeList.size() - 1);
        assertThat(testPipe.getObjectId()).isEqualTo(UPDATED_OBJECT_ID);
        assertThat(testPipe.getyStartCoordinate()).isEqualTo(UPDATED_Y_START_COORDINATE);
        assertThat(testPipe.getxStartCoordinate()).isEqualTo(UPDATED_X_START_COORDINATE);
        assertThat(testPipe.getyEndCoordinate()).isEqualTo(UPDATED_Y_END_COORDINATE);
        assertThat(testPipe.getxEndCoordinate()).isEqualTo(UPDATED_X_END_COORDINATE);
        assertThat(testPipe.getTagId()).isEqualTo(UPDATED_TAG_ID);
        assertThat(testPipe.getPipeName()).isEqualTo(UPDATED_PIPE_NAME);
        assertThat(testPipe.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testPipe.getDiameter()).isEqualTo(UPDATED_DIAMETER);
        assertThat(testPipe.getDiameterUn()).isEqualTo(UPDATED_DIAMETER_UN);
        assertThat(testPipe.getMaterial()).isEqualTo(UPDATED_MATERIAL);
        assertThat(testPipe.getOperationType()).isEqualTo(UPDATED_OPERATION_TYPE);
        assertThat(testPipe.getConstructionYear()).isEqualTo(UPDATED_CONSTRUCTION_YEAR);
        assertThat(testPipe.getp1Length()).isEqualTo(UPDATED_P_1_LENGTH);
        assertThat(testPipe.getActualLength()).isEqualTo(UPDATED_ACTUAL_LENGTH);
        assertThat(testPipe.getComparisonStandard()).isEqualTo(UPDATED_COMPARISON_STANDARD);
        assertThat(testPipe.getLokClass()).isEqualTo(UPDATED_LOK_CLASS);
        assertThat(testPipe.getPipeMaterial()).isEqualTo(UPDATED_PIPE_MATERIAL);
        assertThat(testPipe.getPenTools()).isEqualTo(UPDATED_PEN_TOOLS);
        assertThat(testPipe.getRow()).isEqualTo(UPDATED_ROW);
        assertThat(testPipe.getMaopDp()).isEqualTo(UPDATED_MAOP_DP);
        assertThat(testPipe.getMaxTemperature()).isEqualTo(UPDATED_MAX_TEMPERATURE);
        assertThat(testPipe.getPloNumber()).isEqualTo(UPDATED_PLO_NUMBER);
        assertThat(testPipe.getCoiNumber()).isEqualTo(UPDATED_COI_NUMBER);
        assertThat(testPipe.getRaPipe()).isEqualTo(UPDATED_RA_PIPE);
        assertThat(testPipe.getInspection()).isEqualTo(UPDATED_INSPECTION);
        assertThat(testPipe.getExpired()).isEqualTo(UPDATED_EXPIRED);
        assertThat(testPipe.getModified()).isEqualTo(UPDATED_MODIFIED);
        assertThat(testPipe.getPloDocument()).isEqualTo(UPDATED_PLO_DOCUMENT);
        assertThat(testPipe.getPloReport()).isEqualTo(UPDATED_PLO_REPORT);
        assertThat(testPipe.getCoiDocument()).isEqualTo(UPDATED_COI_DOCUMENT);
        assertThat(testPipe.getRaDocument()).isEqualTo(UPDATED_RA_DOCUMENT);
        assertThat(testPipe.getFile()).isEqualTo(UPDATED_FILE);
        assertThat(testPipe.getFileContentType()).isEqualTo(UPDATED_FILE_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingPipe() throws Exception {
        int databaseSizeBeforeUpdate = pipeRepository.findAll().size();

        // Create the Pipe
        PipeDTO pipeDTO = pipeMapper.toDto(pipe);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPipeMockMvc
            .perform(put("/api/pipes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(pipeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Pipe in the database
        List<Pipe> pipeList = pipeRepository.findAll();
        assertThat(pipeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePipe() throws Exception {
        // Initialize the database
        pipeRepository.saveAndFlush(pipe);

        int databaseSizeBeforeDelete = pipeRepository.findAll().size();

        // Delete the pipe
        restPipeMockMvc
            .perform(delete("/api/pipes/{id}", pipe.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Pipe> pipeList = pipeRepository.findAll();
        assertThat(pipeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
