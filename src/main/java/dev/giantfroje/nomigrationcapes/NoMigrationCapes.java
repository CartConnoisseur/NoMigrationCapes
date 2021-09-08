package dev.giantfroje.nomigrationcapes;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoMigrationCapes implements ModInitializer {
    public static final String MOD_ID = "nomigrationcapes";
    public static final String MOD_NAME = "NoMigrationCapes";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final String MIGRATOR_CAPE_HASH = "2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933";

    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER) {
            LOGGER.error(MOD_NAME + " is a client-side only mod! Please remove it from your server!");
        }
    }
}
