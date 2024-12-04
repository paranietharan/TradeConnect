import React, { useRef } from 'react';
import { Link } from 'react-router-dom';
import styles from './styles/PopularProducts.module.css';

const popularProducts = [
    {
        id: 1,
        name: 'Wireless Headphones',
        image: 'https://via.placeholder.com/200x200',
        price: 99.99,
        rating: 4.5,
        reviews: 128,
        link: '/product/wireless-headphones'
    },
    {
        id: 2,
        name: 'Smart Watch',
        image: 'https://via.placeholder.com/200x200',
        price: 199.99,
        rating: 4.8,
        reviews: 256,
        link: '/product/smart-watch'
    },
    {
        id: 3,
        name: 'Smart Watch',
        image: 'https://via.placeholder.com/200x200',
        price: 199.99,
        rating: 4.8,
        reviews: 256,
        link: '/product/smart-watch'
    },
    {
        id: 4,
        name: 'Smart Watch',
        image: 'https://via.placeholder.com/200x200',
        price: 199.99,
        rating: 4.8,
        reviews: 256,
        link: '/product/smart-watch'
    },
    {
        id: 5,
        name: 'Smart Watch',
        image: 'https://via.placeholder.com/200x200',
        price: 199.99,
        rating: 4.8,
        reviews: 256,
        link: '/product/smart-watch'
    },
];

export default function PopularProducts() {
    const scrollContainerRef = useRef(null);

    const scrollLeft = () => {
        scrollContainerRef.current.scrollBy({ left: -200, behavior: 'smooth' });
    };

    const scrollRight = () => {
        scrollContainerRef.current.scrollBy({ left: 200, behavior: 'smooth' });
    };

    return (
        <div className={styles.popularProductsContainer}>
            <h2 className={styles.title}>Popular Products</h2>
            <div className={styles.productsWrapper}>
                <button className={`${styles.scrollButton} ${styles.left}`} onClick={scrollLeft}>
                    &lt;
                </button>
                <div className={styles.productsSlider} ref={scrollContainerRef}>
                    {popularProducts.map(product => (
                        <Link to={product.link} key={product.id} className={styles.productCard}>
                            <img src={product.image} alt={product.name} className={styles.productImage} />
                            <h3 className={styles.productName}>{product.name}</h3>
                            <p className={styles.productPrice}>${product.price}</p>
                            <div className={styles.productRating}>
                                <span className={styles.stars}>{'★'.repeat(Math.floor(product.rating))}</span>
                                <span className={styles.reviews}>({product.reviews})</span>
                            </div>
                        </Link>
                    ))}
                </div>
                <button className={`${styles.scrollButton} ${styles.right}`} onClick={scrollRight}>
                    &gt;
                </button>
            </div>
        </div>
    );
}