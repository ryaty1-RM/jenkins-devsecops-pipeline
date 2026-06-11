# Diagrama Visual del Pipeline DevSecOps

## Pipeline DEV (Lunes a Viernes 8am)

## Pipeline STAGING (Lunes a Viernes 6pm)

## Pipeline CLEANUP FRIDAY — Viernes 5pm

## Security Gate — Criterios definidos

| Severidad | Límite máximo | Acción si se supera            |
| --------- | ------------- | ------------------------------ |
| CRITICAL  | 0             | Pipeline falla automáticamente |
| HIGH      | 5             | Pipeline falla automáticamente |
| MEDIUM    | Sin límite    | Solo advertencia               |
| LOW       | Sin límite    | Solo advertencia               |

## Herramientas de Seguridad

| Herramienta | Tipo                    | Propósito                                   |
| ----------- | ----------------------- | ------------------------------------------- |
| SCA         | Análisis de composición | Detecta vulnerabilidades en dependencias    |
| Trivy       | Escaneo de contenedores | Detecta CVEs en imágenes Docker             |
| OWASP ZAP   | DAST                    | Análisis dinámico de seguridad en endpoints |

## Arquitectura
