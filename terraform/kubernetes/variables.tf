variable "namespace_name" {
  default = "demo-service"
  type    = "string"
}

variable "nginx_pod_name" {
  default = "demo-service"
  type    = "string"
}

variable "nginx_pod_image" {
  default = "springmvc:latest"
  type    = "string"
}
