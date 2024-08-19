package com.loto.lotoback.file.service;


import com.loto.lotoback.tirage.entity.TirageEntity;
import com.loto.lotoback.tirage.repository.TirageRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FileService {

    public final TirageRepository tirageRepository;

    public FileService(TirageRepository tirageRepository) {
        this.tirageRepository = tirageRepository;
    }

    public boolean hasCsvFormat(MultipartFile file) {
        if ("text/csv".equals(file.getContentType())) {
            return true;
        }
        return false;
    }

    public void processAndSaveData(MultipartFile file) {
        List<TirageEntity> lotoDataList = new ArrayList<>();
        try {
            lotoDataList = csvToData(file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        tirageRepository.saveAll(lotoDataList);

    }

    private List<TirageEntity> csvToData(InputStream inputStream) {
        List<TirageEntity> tirageList = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            CSVParser csvParser =
                    new CSVParser(fileReader, CSVFormat.EXCEL.withFirstRecordAsHeader().withDelimiter(';').withTrim());
            List<CSVRecord> records = csvParser.getRecords();

            for (CSVRecord record : records) {
                List<Integer> sortListTirage1 = this.getDataToSortArray(record, "boule_1", "boule_2",
                        "boule_3", "boule_4", "boule_5");
                TirageEntity tirage =
                        new TirageEntity(sortListTirage1.get(0), sortListTirage1.get(1), sortListTirage1.get(2), sortListTirage1.get(3), sortListTirage1.get(4),
                                LocalDate.parse(record.get("date_de_tirage"), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                tirageList.add(tirage);

                List<Integer> sortListTirage2 = this.getDataToSortArray(record, "boule_1_second_tirage", "boule_2_second_tirage",
                        "boule_3_second_tirage", "boule_4_second_tirage", "boule_5_second_tirage");
                TirageEntity tirage2 =
                        new TirageEntity(sortListTirage2.get(0), sortListTirage2.get(1), sortListTirage2.get(2), sortListTirage2.get(3), sortListTirage2.get(4),
                                LocalDate.parse(record.get("date_de_tirage"), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                tirageList.add(tirage2);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tirageList;
    }

    private List<Integer> getDataToSortArray(CSVRecord record, String data1, String data2, String data3, String data4, String data5) {
        List<Integer> sortArray = new ArrayList<>();
        sortArray.add(Integer.parseInt(record.get(data1)));
        sortArray.add(Integer.parseInt(record.get(data2)));
        sortArray.add(Integer.parseInt(record.get(data3)));
        sortArray.add(Integer.parseInt(record.get(data4)));
        sortArray.add(Integer.parseInt(record.get(data5)));
        Collections.sort(sortArray);
        return sortArray;
    }
}
