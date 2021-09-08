package dev.giantfroje.nomigrationcapes.mixin;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import dev.giantfroje.nomigrationcapes.NoMigrationCapes;
import net.minecraft.client.texture.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(PlayerSkinProvider.class)
public abstract class PlayerSkinProviderMixin {
    @Inject(method = "method_22819(Ljava/util/Map;Lnet/minecraft/client/texture/PlayerSkinProvider$SkinTextureAvailableCallback;Lcom/mojang/authlib/minecraft/MinecraftProfileTexture$Type;)V",
            at = @At(value = "HEAD"))
    private void loadSkin(Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map, PlayerSkinProvider.SkinTextureAvailableCallback callback, MinecraftProfileTexture.Type type, CallbackInfo ci) {
        if (type == MinecraftProfileTexture.Type.CAPE) {
            if (map.containsKey(type)) {
                if (map.get(type).getHash().equals(NoMigrationCapes.MIGRATOR_CAPE_HASH)) {
                    map.remove(type);
                }
            }
        }
    }
}
