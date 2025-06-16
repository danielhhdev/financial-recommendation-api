-- Producto 1: Cuenta Joven
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'a1d0c6e8-1234-4b9b-8d9a-0123456789ab',
    'Cuenta Joven',
    'Cuenta bancaria para menores de 30 años, sin comisiones, con transferencias gratuitas y acceso a promociones especiales.',
    'ACCOUNT',
    0.2,
    0,
    0,
    0,
    'Ser menor de 30 años.',
    'LOW',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('a1d0c6e8-1234-4b9b-8d9a-0123456789ab', 'Sin comisiones'),
('a1d0c6e8-1234-4b9b-8d9a-0123456789ab', 'Transferencias gratuitas'),
('a1d0c6e8-1234-4b9b-8d9a-0123456789ab', 'Descuentos en ocio');

-- Producto 2: Préstamo Personal Flexible
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'b2d0c6e8-4321-4c9b-8d9a-9876543210ab',
    'Préstamo Personal Flexible',
    'Préstamo hasta 30.000€ a tipo fijo, con posibilidad de cancelación anticipada sin penalización y aprobación en 24 horas.',
    'LOAN',
    3.5,
    100,
    1000,
    30000,
    'Ingresos superiores a 1.000€/mes.',
    'MEDIUM',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('b2d0c6e8-4321-4c9b-8d9a-9876543210ab', 'Aprobación rápida'),
('b2d0c6e8-4321-4c9b-8d9a-9876543210ab', 'Cancelación anticipada gratuita');

-- Producto 3: Tarjeta Oro
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'c3e0d2e8-9999-4c9b-8d9a-222222222222',
    'Tarjeta Oro',
    'Tarjeta de crédito Oro con seguro de viaje, acceso a salas VIP en aeropuertos y pago sin contacto.',
    'CREDIT_CARD',
    18.0,
    50,
    0,
    0,
    'Ingresos mensuales superiores a 1.500€.',
    'LOW',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('c3e0d2e8-9999-4c9b-8d9a-222222222222', 'Seguro de viaje incluido'),
('c3e0d2e8-9999-4c9b-8d9a-222222222222', 'Acceso a salas VIP'),
('c3e0d2e8-9999-4c9b-8d9a-222222222222', 'Pago sin contacto');

-- Producto 4: Fondo Tecnología Global
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'd4a1e5e8-8888-4c9b-8d9a-333333333333',
    'Fondo Tecnología Global',
    'Fondo de inversión en empresas tecnológicas de alto crecimiento internacional. Riesgo elevado.',
    'INVESTMENT_FUND',
    NULL,
    1.5,
    500,
    NULL,
    'Perfil de riesgo AGGRESSIVE. Inversión mínima 500€.',
    'HIGH',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('d4a1e5e8-8888-4c9b-8d9a-333333333333', 'Gestión activa'),
('d4a1e5e8-8888-4c9b-8d9a-333333333333', 'Diversificación internacional');

-- Producto 5: Seguro Vida Integral
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'e5b2f6f8-5555-4d9b-8d9a-444444444444',
    'Seguro Vida Integral',
    'Seguro de vida familiar con cobertura por fallecimiento, invalidez y enfermedades graves. Incluye asistencia 24h.',
    'INSURANCE',
    NULL,
    30,
    0,
    NULL,
    'Edad máxima de contratación: 65 años.',
    'LOW',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('e5b2f6f8-5555-4d9b-8d9a-444444444444', 'Asistencia 24h'),
('e5b2f6f8-5555-4d9b-8d9a-444444444444', 'Cobertura enfermedades graves'),
('e5b2f6f8-5555-4d9b-8d9a-444444444444', 'Flexibilidad de pago');

-- Producto 6: Hipoteca Variable
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'f6c3a7b8-6666-4d9b-8d9a-555555555555',
    'Hipoteca Variable',
    'Préstamo hipotecario con tipo de interés variable, plazo hasta 30 años, y posibilidad de carencia inicial.',
    'MORTGAGE',
    2.2,
    500,
    50000,
    500000,
    'Ingresos estables, estudio de solvencia favorable.',
    'MEDIUM',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('f6c3a7b8-6666-4d9b-8d9a-555555555555', 'Carencia inicial 12 meses'),
('f6c3a7b8-6666-4d9b-8d9a-555555555555', 'Plazo flexible'),
('f6c3a7b8-6666-4d9b-8d9a-555555555555', 'Amortización anticipada');

-- Producto 7: Cuenta Nómina Premium
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'f7e9c2f1-7001-4aaa-bbbb-111111111111',
    'Cuenta Nómina Premium',
    'Cuenta corriente con remuneración para nómina domiciliada, sin comisiones y con devolución de recibos principales.',
    'ACCOUNT',
    0.5,
    0,
    0,
    0,
    'Nómina domiciliada superior a 1.200€/mes.',
    'LOW',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('f7e9c2f1-7001-4aaa-bbbb-111111111111', 'Remuneración saldo'),
('f7e9c2f1-7001-4aaa-bbbb-111111111111', 'Devolución de recibos'),
('f7e9c2f1-7001-4aaa-bbbb-111111111111', 'Sin comisiones');

-- Producto 8: Plan de Pensiones Futuro Seguro
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'a8c9d8b2-8002-4bbb-cccc-222222222222',
    'Plan de Pensiones Futuro Seguro',
    'Plan de pensiones conservador con aportaciones flexibles y cobertura de fallecimiento.',
    'PENSION_PLAN',
    NULL,
    0.8,
    30,
    NULL,
    'Edad de contratación entre 18 y 60 años.',
    'LOW',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('a8c9d8b2-8002-4bbb-cccc-222222222222', 'Cobertura fallecimiento'),
('a8c9d8b2-8002-4bbb-cccc-222222222222', 'Aportaciones flexibles');

-- Producto 9: Tarjeta de Débito Joven
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'b9d1e8f3-9003-4ccc-dddd-333333333333',
    'Tarjeta de Débito Joven',
    'Tarjeta de débito para menores de 25 años con retiradas gratuitas en todos los cajeros nacionales.',
    'CREDIT_CARD',
    NULL,
    0,
    0,
    0,
    'Edad máxima 25 años.',
    'LOW',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('b9d1e8f3-9003-4ccc-dddd-333333333333', 'Retiradas gratis en cajeros'),
('b9d1e8f3-9003-4ccc-dddd-333333333333', 'Control parental opcional'),
('b9d1e8f3-9003-4ccc-dddd-333333333333', 'Pago móvil');

-- Producto 10: Fondo de Inversión Sostenible
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'c10e4f9a-1004-4ddd-eeee-444444444444',
    'Fondo Sostenible Global',
    'Fondo de inversión enfocado en empresas con alto compromiso ambiental y social. Diversificación internacional.',
    'INVESTMENT_FUND',
    NULL,
    1.2,
    1000,
    NULL,
    'Perfil de riesgo MODERATE. Inversión mínima 1.000€.',
    'MEDIUM',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('c10e4f9a-1004-4ddd-eeee-444444444444', 'Inversión sostenible'),
('c10e4f9a-1004-4ddd-eeee-444444444444', 'Diversificación internacional');

-- Producto 11: Seguro Salud Plus
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'd11f5a6b-1105-4eee-affe-555555555555',
    'Seguro Salud Plus',
    'Seguro médico privado con acceso a especialistas sin copago, hospitalización incluida y cobertura dental básica.',
    'INSURANCE',
    NULL,
    45,
    0,
    NULL,
    'Sin exclusiones por enfermedades preexistentes.',
    'LOW',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('d11f5a6b-1105-4eee-affe-555555555555', 'Cobertura dental'),
('d11f5a6b-1105-4eee-affe-555555555555', 'Hospitalización incluida'),
('d11f5a6b-1105-4eee-affe-555555555555', 'Acceso a especialistas');

-- Producto 12: Microcrédito Express
INSERT INTO products (
    id, name, description, type, interest_rate, fees, min_amount, max_amount, eligibility_criteria, risk_level, embedding
) VALUES (
    'e12a6a7c-1206-4fff-aaaa-666666666666',
    'Microcrédito Express',
    'Préstamo rápido de hasta 1.000€, aprobación instantánea, ideal para imprevistos y sin comisiones ocultas.',
    'LOAN',
    8.5,
    0,
    100,
    1000,
    'Residente en España, ingresos demostrables.',
    'HIGH',
    NULL
);

INSERT INTO product_features (product_id, features) VALUES
('e12a6a7c-1206-4fff-aaaa-666666666666', 'Aprobación instantánea'),
('e12a6a7c-1206-4fff-aaaa-666666666666', 'Sin comisiones ocultas'),
('e12a6a7c-1206-4fff-aaaa-666666666666', 'Ideal para imprevistos');
