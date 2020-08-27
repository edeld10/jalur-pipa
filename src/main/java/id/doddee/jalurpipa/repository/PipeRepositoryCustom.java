package id.doddee.jalurpipa.repository;

import id.doddee.jalurpipa.domain.Pipe;
import java.util.List;

public interface PipeRepositoryCustom {
    boolean bulkUpsert(List<Pipe> pipes);
}
