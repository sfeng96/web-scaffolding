package learning.scaffolding.web.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private DatabaseClient databaseClient;


}
