
package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.Map;

public class OxhaulerRenderer extends MobRenderer<OxhaulerEntity, OxhaulerModel<OxhaulerEntity>> {
    private static final Map<OxhaulerVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(OxhaulerVariant.class), map -> {
                map.put(OxhaulerVariant.BRASS,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_brass.png"));
                map.put(OxhaulerVariant.COPPER,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_copper.png"));
                map.put(OxhaulerVariant.ANDESITE,
                        ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/oxhauler_andesite.png"));
            });

    public OxhaulerRenderer(EntityRendererProvider.Context context) {
        super(context, new OxhaulerModel<>(context.bakeLayer(BionicsModelLayers.OXHAULER)), 1.6f);
        this.addLayer(new OxhaulerGlowLayer(this, context.getModelSet()));
        this.addLayer(new OxhaulerColorLayer(this, context.getModelSet()));
        this.addLayer(new OxhaulerColorLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(OxhaulerEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(OxhaulerEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isPassenger()) {
            poseStack.translate(0, -6 / 16f, 0);
        }

        if (entity.getFuel() > 0) {
            CachedBuffers.partial(PartialModel.of(entity.getFuel() < 23000
                            ? CreateBionics.asResource("item/oxhauler_fire")
                            : CreateBionics.asResource("item/oxhauler_soul_fire")), entity.getBlockStateOn())
                    .rotate(Direction.Axis.Y, -entityYaw * Mth.PI / 180)
                    .translate(-0.5, 0.75, -0.5)
                    .light(15728880)
                    .renderInto(poseStack, buffer.getBuffer(RenderType.cutout()));
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public boolean shouldRender(OxhaulerEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
