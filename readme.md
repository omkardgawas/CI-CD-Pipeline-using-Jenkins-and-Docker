# 🚀 DevOps Project 3 — CI/CD Pipeline using Jenkins & Docker

## 📌 Project Overview

This project demonstrates a complete CI/CD pipeline using Jenkins, Docker, and AWS EC2.

The pipeline automates:

* Code fetching from GitHub
* Docker image build
* Container deployment on EC2

---

## 🏗️ Architecture

Developer → GitHub → Jenkins → Docker → EC2 → Live Application

---

## ⚙️ Technologies Used

* AWS EC2
* Jenkins (Dockerized)
* Docker
* Nginx
* GitHub

---

## 🪜 Pipeline Workflow

### 1️⃣ Clone Code

Jenkins pulls the latest code from GitHub repository.

### 2️⃣ Build Docker Image

Docker image is built using Dockerfile.

### 3️⃣ Deploy Container

Container is deployed automatically on EC2 instance.

---

## 🧱 Setup Steps

### 🔹 1. Launch EC2 Instance

* Ubuntu instance (t2.micro)
* Open ports:

  * 22 (SSH)
  * 80 (HTTP)
  * 8080 (Jenkins)
  * 8081 (Application)

---

### 🔹 2. Install Docker

```bash
sudo apt update
sudo apt install docker.io -y
sudo systemctl start docker
```

---

### 🔹 3. Run Jenkins in Docker

```bash
docker run -d \
  --name jenkins \
  -p 8080:8080 \
  -p 50000:50000 \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v jenkins_home:/var/jenkins_home \
  jenkins/jenkins:lts-jdk17
```

---

### 🔹 4. Install Docker inside Jenkins

```bash
docker exec -u root -it jenkins bash
apt update
apt install docker.io -y
```

---

### 🔹 5. Create Jenkins Pipeline

* Add Jenkinsfile
* Configure pipeline job

---

## 🌐 Output

Application deployed and accessible at:

http://44.204.114.214:8080

---

## 📸 Screenshots

### 🔹 Jenkins Pipeline Success

<img width="1918" height="968" alt="image" src="https://github.com/user-attachments/assets/3f9ccf53-841e-465c-97e1-b9eb3884fe41" />


### 🔹 Console Output

<img width="1897" height="967" alt="image" src="https://github.com/user-attachments/assets/73384303-0762-47d6-8c77-ed4c124c90f2" />


### 🔹 Application Running

(Add screenshot here)

---

## ⚠️ Issues Faced & Fixes

### ❌ Git branch issue

* Jenkins defaulted to master
* Fixed by specifying main branch

---

### ❌ Docker not found

* Jenkins container lacked Docker CLI
* Installed Docker inside container

---

### ❌ Port conflict (80)

* Nginx was using port 80
* Fixed by using port 8081

---

## 🧠 Key Learnings

* CI/CD pipeline creation using Jenkins
* Docker containerization and deployment
* Debugging real-world DevOps issues
* Jenkins + Docker integration

---

## 💬 Interview Explanation

"I built a CI/CD pipeline using Jenkins that automatically pulls code from GitHub, builds a Docker image, and deploys it on an EC2 instance. I also resolved issues like Docker access inside Jenkins and port conflicts."

---

## 🔮 Future Improvements

* Add GitHub Webhook (auto trigger)
* Use Docker Compose
* Add monitoring (Prometheus + Grafana)
