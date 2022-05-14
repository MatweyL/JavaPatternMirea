package com.example.task18.service;

import com.example.task18.entity.Jsonable;
import com.example.task18.entity.Manufacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.task18.entity.Worker;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ScheduleService implements ScheduleServiceBean{
    private final String BACKUP_DIR = "D:\\University\\4_semestr\\SHPPNYAD\\JavaPatternMirea\\src\\ru\\mirea\\task22\\src\\main\\java\\backups\\";//java/backups/
    private final ManufactureService manufactureService;
    private final WorkerService workerService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu H-m");

    @Autowired
    public ScheduleService(ManufactureService manufactureService, WorkerService workerService) {
        this.manufactureService = manufactureService;
        this.workerService = workerService;
    }

    @Override
    @Scheduled(fixedRate = 60000L)
    public void backupFromDatabase() throws IOException {
        deleteOldDirectories();

        String dirName = LocalDateTime.now().format(formatter);
        String dirPath =  BACKUP_DIR + dirName;
        new File(dirPath).mkdirs();

        File manufactureBackup = new File(dirPath + "/manufacture_backup");
        File workerBackup = new File(dirPath + "/worker_backup");

        List<Worker> workers = workerService.readAll();
        List<Manufacture> manufactures = manufactureService.readAll();

        writeToFiles(workers, workerBackup);
        writeToFiles(manufactures, manufactureBackup);
    }

    private void writeToFiles(List<? extends Jsonable> objects, File file) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        for (Jsonable o : objects) {
            printWriter.println(o.toString());
            printWriter.println();
        }
        printWriter.close();
    }

    private void deleteOldDirectories() {
        File file = new File(BACKUP_DIR);
        System.out.println(file.isDirectory());
        File[] files = file.listFiles();
        long curTime = System.currentTimeMillis();
        for (File f : files) {
            System.out.println(f);
            if (curTime - f.lastModified() > 600_000) {
//                boolean deleted = FileSystemUtils.deleteRecursively(f);
//                if (deleted) {
//                    System.out.println(f.getName() + " is deleted");
//                } else {
//                    System.err.println(f.getName() + " is not deleted");
//                }
            }
        }
    }
}