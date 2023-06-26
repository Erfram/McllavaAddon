package llama.mcllava;

import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@Mod(
        modid = Mcllava.MOD_ID,
        name = Mcllava.MOD_NAME,
        version = Mcllava.VERSION
)
public class Mcllava {

    public static final String MOD_ID = "mcllava";
    public static final String MOD_NAME = "Mcllava_Addon";
    public static final String VERSION = "0.1.1";
    public static final Logger LOGGER = LogManager.getLogManager().getLogger(MOD_ID);

    public static final SimpleNetworkWrapper NETWORK = new SimpleNetworkWrapper(Mcllava.MOD_ID);

    @SidedProxy(clientSide = "llama.mcllava.ClientProxy", serverSide = "llama.mcllava.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    public static Mcllava INSTANCE;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}