INSERT INTO `Card_Product`
    (`id`,`card_id`,`p1_building_id`, `p2_building_id`,`p1_building_number`,`p2_building_number`,
    `p1_resource_id`,`p2_resource_id`,`p1_resource_number`,`p2_resource_number`,`p1_upgrade_id`,
    `p2_upgrade_id`,`p1_upgrade_number`,`p2_upgrade_number`,`necessary_building_id`,
    `necessary_upgrade_id`,`necessary_building_number`,`necessary_upgrade_number`)
VALUES
    ('1','1','1',NULL,'1',NULL,'1',NULL,'-150',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
    ('2','1','1',NULL,'1',NULL,'2',NULL,'-150',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
    ('3','2','1',NULL,NULL,NULL,'1',NULL,'-150',NULL,'1',NULL,NULL,NULL,'1',NULL,'1',NULL),
    ('4','2','1',NULL,NULL,NULL,'2',NULL,'-150',NULL,'1',NULL,NULL,NULL,'1',NULL,'1',NULL),
    ('5','3',NULL,NULL,NULL,NULL,'1','2','-2000','-1000',NULL,NULL,NULL,NULL,'3','3','1','10'),
    ('6','3',NULL,NULL,NULL,NULL,NULL,'3',NULL,'-1000',NULL,NULL,NULL,NULL,'3','3','1','10'),
    ('7','3',NULL,NULL,NULL,NULL,NULL,'5',NULL,'-1000',NULL,NULL,NULL,NULL,'3','3','1','10'),
    ('8','3',NULL,NULL,NULL,NULL,NULL,'6',NULL,'-1000',NULL,NULL,NULL,NULL,'3','3','1','10'),
    ('9','4',NULL,NULL,NULL,NULL,'7','7','-150','-100',NULL,NULL,NULL,NULL,'7',NULL,'1',NULL);