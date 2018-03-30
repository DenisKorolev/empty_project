package ru.bellintegrator.practice.worker.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.worker.dao.WorkerDAO;
import ru.bellintegrator.practice.worker.service.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService{

    private final Logger log = LoggerFactory.getLogger(WorkerServiceImpl.class);

    private final WorkerDAO dao;

    @Autowired
    public WorkerServiceImpl(WorkerDAO dao){
        this.dao = dao;
    }


}
