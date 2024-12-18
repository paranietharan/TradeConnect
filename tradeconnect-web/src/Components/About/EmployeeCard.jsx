import { Link } from 'react-router-dom'
import styles from './styles/EmployeeCard.module.css'

export default function EmployeeCard({ img, name, position, social }) {
    return (
        <div className={styles.EmployeeCardContainer}>
            <div className={styles.image}>
                <img
                    src={img}
                    alt='profile picture' />
            </div>
            <p className={styles.name}>{name}</p>
            <p className={styles.position}>{position}</p>
            <div className={styles.socialMedia}>
                {social &&
                    Object.entries(social).map(([platform, url]) => (
                        <a 
                            key={platform} 
                            href={url} 
                            target="_blank" 
                            rel="noopener noreferrer"
                            className={styles.icon}
                        >
                            <i className={`bi bi-${platform}`}></i>
                        </a>
                    ))
                }
            </div>
        </div>
    )
}