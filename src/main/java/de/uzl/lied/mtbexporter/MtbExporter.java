package de.uzl.lied.mtbexporter;

import de.uzl.lied.mtbexporter.jobs.CheckFhirServer;
import de.uzl.lied.mtbexporter.settings.ConfigurationLoader;
import de.uzl.lied.mtbexporter.settings.Settings;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import org.tinylog.Logger;

/**
 * Regularily queries FHIR server for new MTB therapie recommendations and
 * exports them.
 */
public final class MtbExporter {

    private MtbExporter() {
    }

    /**
     * Entry point method for MtbExporter.
     *
     * @param args Custom settings file can be set as custom arg.
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        InputStream settingsYaml = ClassLoader.getSystemClassLoader().getResourceAsStream("settings.yaml");
        if (args.length == 1) {
            settingsYaml = new FileInputStream(args[0]);
        }

        ConfigurationLoader configLoader = new ConfigurationLoader();
        configLoader.loadConfiguration(settingsYaml, Settings.class);

        Timer t = new Timer();
        CheckFhirServer checkFhirServer = new CheckFhirServer();
        t.scheduleAtFixedRate(checkFhirServer, 0, Settings.getCronIntervall());

        Logger.info("MtbExporter started!");
    }
}
