CREATE TABLE image(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_name` varchar(255) NULL,
  `image_path` varchar(255) NULL,
  `image_dhash` varchar(255) NULL,
  `image_type` varchar(255) NULL,
  `create_time` datetime(0) NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE url_image(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) NULL,
  `create_time` datetime(0) NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE url_upload_log(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) NULL,
  `create_time` datetime(0) NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE user(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NULL,
  `user_name` varchar(255) NULL,
  `user_type` tinyint NULL,
  PRIMARY KEY (`id`)
);