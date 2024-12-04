import React from 'react';
import { Link } from 'react-router-dom';
import styles from './styles/CategorySection.module.css';

const categories = [
    { id: 1, name: 'Electronics', icon: '🔌', link: '/category/electronics' },
    { id: 2, name: 'Fashion', icon: '👕', link: '/category/fashion' },
    { id: 3, name: 'Home & Garden', icon: '🏠', link: '/category/home-garden' },
    { id: 4, name: 'Sports', icon: '⚽', link: '/category/sports' },
    { id: 5, name: 'Beauty', icon: '💄', link: '/category/beauty' },
    { id: 6, name: 'Toys', icon: '🎮', link: '/category/toys' },
    { id: 7, name: 'Books', icon: '📚', link: '/category/books' },
    { id: 8, name: 'Automotive', icon: '🚗', link: '/category/automotive' }
];

export default function CategorySection() {
    return (
        <div className={styles.categorySection}>
            <h2 className={styles.categoryTitle}>Shop By Category</h2>
            <div className={styles.categoryContainer}>
                {categories.map(category => (
                    <Link to={category.link} key={category.id} className={styles.categoryCard}>
                        <span className={styles.categoryIcon}>{category.icon}</span>
                        <span className={styles.categoryName}>{category.name}</span>
                    </Link>
                ))}
            </div>
        </div>
    );
}