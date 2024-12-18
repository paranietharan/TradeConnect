import { useState } from 'react';
import EmployeeCard from './EmployeeCard';
import styles from './styles/EmployeeDetailsBar.module.css';

import CEOImage from '../../assets/key-peoples/ceo.jpg';

export default function EmployeeDetailsBar() {
    const employees = [
        {
            img: CEOImage,
            name: "David David",
            position: "CEO",
            social: {
                twitter: "https://twitter.com/example",
                instagram: "https://instagram.com/example",
                linkedin: "https://linkedin.com/in/example",
            },
        },
        {
            img: CEOImage,
            name: "John Smith",
            position: "CFO",
            social: {
                twitter: "https://twitter.com/example",
                instagram: "https://instagram.com/example",
                linkedin: "https://linkedin.com/in/example",
            },
        },
        {
            img: CEOImage,
            name: "Jane Doe",
            position: "CTO",
            social: {
                twitter: "https://twitter.com/example",
                instagram: "https://instagram.com/example",
                linkedin: "https://linkedin.com/in/example",
            },
        },
        {
            img: CEOImage,
            name: "Mary Ann",
            position: "CMO",
            social: {
                twitter: "https://twitter.com/example",
                instagram: "https://instagram.com/example",
                linkedin: "https://linkedin.com/in/example",
            },
        },
        {
            img: CEOImage,
            name: "Chris Brown",
            position: "COO",
            social: {
                twitter: "https://twitter.com/example",
                instagram: "https://instagram.com/example",
                linkedin: "https://linkedin.com/in/example",
            },
        },
    ];

    const [currentIndex, setCurrentIndex] = useState(0);

    const handleDotClick = (index) => {
        setCurrentIndex(index);
    };

    const totalPages = Math.ceil(employees.length / 3);

    return (
        <div className={styles.EmployeeDetailsBarContainer}>
            <div
                className={styles.EmployeeCarousel}
                style={{ transform: `translateX(-${currentIndex * 100}%)` }}
            >
                {employees.map((employee, index) => (
                    <div className={styles.Employee} key={index}>
                        <EmployeeCard {...employee} />
                    </div>
                ))}
            </div>
            <div className={styles.DotsContainer}>
                {Array(totalPages)
                    .fill()
                    .map((_, index) => (
                        <span
                            key={index}
                            className={`${styles.Dot} ${currentIndex === index ? styles.ActiveDot : ''}`}
                            onClick={() => handleDotClick(index)}
                        ></span>
                    ))}
            </div>
        </div>
    );
}