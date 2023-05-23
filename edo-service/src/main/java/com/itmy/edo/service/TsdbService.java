package com.itmy.edo.service;

import com.itmy.edo.model.dto.UniteMetricData;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface TsdbService {
    void createDatabase(String database);

    void dropDatabase(String database);

    boolean databaseExist(String database);

    void createRetentionPolicy();

    void createRetentionPolicy(String database, String policyName, String duration, int replication, Boolean isDefault);

    void dropRetentionPolicy();

    void dropRetentionPolicy(String database, String retentionPolicy);

    void createContinuousQuery(String measurement, String extendPolicy);

    boolean continuousQueryExists(String measurement);

    boolean continuousQueryExists(String database, String cqName);


    boolean measurementsExists(String measurement);

    boolean measurementsExists(String database, String measurement);

    void QueryResultquery(String command);

    void QueryResultdataQuery(String command);

    void insert(Point point1);

    void insert(String measurement, TimeUnit timeUnit, UniteMetricData data);

    void batchInsert(BatchPoints batchPoints);

    void PointpointBuilder(String measurement,

                           Map tags,

                           Map fields,

                           long time,

                           TimeUnit timeunit);

    void BatchPointsbuildBatchPoints();

    void BatchPointsbatchPointsBuilder(String database, InfluxDB.ConsistencyLevel level, TimeUnit precision);

    void BatchPointsbatchPointsBuilder(String database, InfluxDB.ConsistencyLevel level, TimeUnit precision, String retentionPolicy);
}
