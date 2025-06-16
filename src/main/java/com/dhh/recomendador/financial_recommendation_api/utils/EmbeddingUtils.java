package com.dhh.recomendador.financial_recommendation_api.utils;

import com.dhh.recomendador.financial_recommendation_api.model.Product;
import com.dhh.recomendador.financial_recommendation_api.model.User;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class EmbeddingUtils {

    private EmbeddingUtils() {}

    public static double cosineSimilarity(Double[] vectorA, Double[] vectorB) {
        // Convierte Double[] a double[]
        double[] arrA = java.util.Arrays.stream(vectorA).mapToDouble(Double::doubleValue).toArray();
        double[] arrB = java.util.Arrays.stream(vectorB).mapToDouble(Double::doubleValue).toArray();

        INDArray ndA = Nd4j.create(arrA);
        INDArray ndB = Nd4j.create(arrB);

        // Calcula cosine similarity usando Nd4j
        double sim = Nd4j.getExecutioner().execAndReturn(
                new org.nd4j.linalg.api.ops.impl.reduce3.CosineSimilarity(ndA, ndB)
        ).getFinalResult().doubleValue();

        return sim;
    }

    public static String buildReason(Product product, User user, Double similarity) {
        StringBuilder reason = new StringBuilder();

        // Explicación basada en perfil de riesgo
        if (product.getRiskLevel() != null && user.getRiskProfile() != null) {
            if (product.getRiskLevel().toString().equalsIgnoreCase(user.getRiskProfile().toString())) {
                reason.append("Este producto se ajusta a tu perfil de riesgo");
            } else {
                reason.append("Este producto podría interesarte aunque su riesgo es ")
                        .append(product.getRiskLevel().toString().toLowerCase());
            }
        }

        // Añade objetivo financiero si encaja
        if (user.getFinancialGoals() != null && product.getFeatures() != null) {
            for (String goal : user.getFinancialGoals()) {
                if (product.getFeatures().stream().anyMatch(f -> f.toLowerCase().contains(goal.toLowerCase()))) {
                    if (reason.length() > 0) reason.append(". ");
                    reason.append("Está alineado con tu objetivo de '").append(goal).append("'");
                    break;
                }
            }
        }

        // Añade tipo de producto si no hay coincidencia previa
        if (reason.length() == 0 && product.getType() != null) {
            reason.append("Recomendado por afinidad con tu perfil y porque es un producto de tipo ")
                    .append(product.getType().toString().toLowerCase());
        }

        // Si tienes un score alto, personaliza más
        if (similarity != null && similarity > 0.90) {
            if (reason.length() > 0) reason.append(". ");
            reason.append("La afinidad con tu perfil es muy alta.");
        }

        // Si no hay nada, razón genérica
        if (reason.length() == 0) {
            reason.append("Basado en tu perfil financiero y preferencias.");
        }

        return reason.toString();
    }
}
