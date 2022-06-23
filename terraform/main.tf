resource "aws_s3_bucket" "s3_bucket_obs" {
  bucket = "obs-absa-dev"
  acl = "private"
}

resource "aws_s3_bucket_object" "s3_bucket_object_obs" {
  bucket = aws_s3_bucket.s3_bucket_obs.id
  key = "beanstalk/obs"
  source = "../target/obs-0.0.1-SNAPSHOT.jar"
}

resource "aws_elastic_beanstalk_application" "beanstalk_obs" {
  name = "obs"
  description = "Online Book Store application"
}

resource "aws_elastic_beanstalk_application_version" "beanstalk_obs_version" {
  application = aws_elastic_beanstalk_application.beanstalk_obs.name
  bucket = aws_s3_bucket.s3_bucket_obs.id
  key = aws_s3_bucket_object.s3_bucket_object_obs.id
  name = "obs-0.0.1-SNAPSHOT"
}

resource "aws_elastic_beanstalk_environment" "beanstalk_obs_env" {
  name = "obs-dev"
  application = aws_elastic_beanstalk_application.beanstalk_obs.name
  solution_stack_name = "64bit Amazon Linux 2 v3.2.16 running Corretto 11"
  version_label = aws_elastic_beanstalk_application_version.beanstalk_obs_version.name

  setting {
    name = "SERVER_PORT"
    namespace = "aws:elasticbeanstalk:application:environment"
    value = "5000"
  }

  setting {
    namespace = "aws:ec2:instances"
    name = "InstanceTypes"
    value = "t2.micro"
  }

  setting {
    namespace = "aws:autoscaling:launchconfiguration"
    name = "IamInstanceProfile"
    value = "aws-elasticbeanstalk-ec2-role"
  }
}
