import React, { useRef } from 'react';
import styles from './styles/Arrival.module.css';

const newArrivals = [
    {
        id: 1,
        image: 'https://via.placeholder.com/200x150',
        link: '/product/1',
        title: 'New Arrival 1'
    },
    {
        id: 2,
        image: 'https://via.placeholder.com/200x150',
        link: '/product/2',
        title: 'New Arrival 2'
    },
    {
        id: 3,
        image: 'https://via.placeholder.com/200x150',
        link: '/product/3',
        title: 'New Arrival 3'
    },
    {
        id: 4,
        image: 'https://via.placeholder.com/200x150',
        link: '/product/4',
        title: 'New Arrival 4'
    },
    {
        id: 5,
        image: 'https://via.placeholder.com/200x150',
        link: '/product/4',
        title: 'New Arrival 4'
    }
];

function NewArrival() {
    const scrollContainerRef = useRef(null);

    const scrollLeft = () => {
        scrollContainerRef.current.scrollBy({ left: -200, behavior: 'smooth' });
    };

    const scrollRight = () => {
        scrollContainerRef.current.scrollBy({ left: 200, behavior: 'smooth' });
    };

    return (
        <div className={styles.newArrivalContainer}>
            <h1 className={styles.newArrivalTitle}>New Arrivals!</h1>
            <button className={`${styles.scrollButton} ${styles.left}`} onClick={scrollLeft}>
                &lt;
            </button>
            <div className={styles.newArrivalGrid} ref={scrollContainerRef}>
                {newArrivals.map(item => (
                    <div key={item.id} className={styles.newArrivalItem}>
                        <img src={item.image} alt={item.title} className={styles.newArrivalImage} />
                        <a href={item.link} className={styles.newArrivalLink}>{item.title}</a>
                    </div>
                ))}
            </div>
            <button className={`${styles.scrollButton} ${styles.right}`} onClick={scrollRight}>
                &gt;
            </button>
        </div>
    );
}

export default NewArrival;