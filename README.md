# Jenkins DevSecOps Pipeline

Infraestructura de integración continua construida con Jenkins Master en Docker sobre Ubuntu Server, con dos nodos esclavos conectados por SSH. Desarrollado como parte del curso de DevOps en la Universidad Mariano Gálvez de Guatemala.

---

## 🏗️ Arquitectura

- **Jenkins Master** corriendo en Docker dentro de Ubuntu Server (VirtualBox)
- **nodo-dev** — nodo esclavo conectado por SSH
- **nodo-staging** — nodo esclavo conectado por SSH
- **3 pipelines** configurados incluyendo pipeline de limpieza automática los viernes

---

## 🛠️ Tecnologías

![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Ubuntu](https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white)
![VirtualBox](https://img.shields.io/badge/VirtualBox-183A61?style=for-the-badge&logo=virtualbox&logoColor=white)

---

## 📂 Estructura
jenkins/
├── pipelines/
│   ├── pipeline-dev.groovy
│   ├── pipeline-staging.groovy
│   └── pipeline-cleanup-friday.groovy
└── docker-compose.ym

---

## 🚀 Cómo levantar el entorno

```bash
# Levantar Jenkins Master con Docker
docker-compose up -d

# Verificar que el contenedor esté corriendo
docker ps
```

---

## 📸 Screenshots

> _Agrega aquí screenshots de Jenkins, los nodos y los pipelines_

---

## 🔗 Relacionado

Los tests E2E que se ejecutan en este pipeline están en [cypress-saucedemo](https://github.com/ryaty1-RM/cypress-saucedemo)
