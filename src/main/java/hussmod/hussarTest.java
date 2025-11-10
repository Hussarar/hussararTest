package hussmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import hussmod.capability.CapabilityExampleHandler;
import hussmod.handlers.ModRegistry;
import hussmod.proxy.CommonProxy;

@Mod(modid = hussarTest.MODID, version = hussarTest.VERSION, name = hussarTest.NAME, dependencies = "required-after:fermiumbooter")
public class hussarTest {
    public static final String MODID = "hussmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "hussarTest";
    public static final Logger LOGGER = LogManager.getLogger();
    public static boolean completedLoading = false;
	
    @SidedProxy(clientSide = "hussmod.proxy.ClientProxy", serverSide = "hussmod.proxy.CommonProxy")
    public static CommonProxy PROXY;
	
	@Instance(MODID)
	public static hussarTest instance;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModRegistry.init();
        hussarTest.PROXY.preInit();

        CapabilityExampleHandler.registerCapability();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        completedLoading = true;
    }
}