import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import styles from './styles/ProductGrid.module.css';

const products = Array.from({ length: 20 }, (_, i) => ({
    id: i + 1,
    name: `Product ${i + 1}`,
    image: 'https://via.placeholder.com/300',
    price: Math.floor(Math.random() * 900) + 100,
    rating: (Math.random() * 2 + 3).toFixed(1),
    reviews: Math.floor(Math.random() * 500),
    discount: Math.floor(Math.random() * 30),
    category: ['Electronics', 'Fashion', 'Home'][Math.floor(Math.random() * 3)]
}));

export default function ProductGrid() {
    const [sortBy, setSortBy] = useState('popularity');

    return (
        <div className={styles.productGridContainer}>
            <div className={styles.productHeader}>
                <h2 className={styles.title}>All Products</h2>
                <div className={styles.filters}>
                    <select 
                        className={styles.sortSelect}
                        value={sortBy}
                        onChange={(e) => setSortBy(e.target.value)}
                    >
                        <option value="popularity">Most Popular</option>
                        <option value="priceLow">Price: Low to High</option>
                        <option value="priceHigh">Price: High to Low</option>
                        <option value="rating">Highest Rated</option>
                    </select>
                </div>
            </div>
            
            <div className={styles.productGrid}>
                {products.map(product => (
                    <Link to={`/product/${product.id}`} key={product.id} className={styles.productCard}>
                        <div className={styles.productImageWrapper}>
                            <img src={product.image} alt={product.name} className={styles.productImage} />
                            {product.discount > 0 && (
                                <span className={styles.discountBadge}>-{product.discount}%</span>
                            )}
                        </div>
                        <div className={styles.productInfo}>
                            <h3 className={styles.productName}>{product.name}</h3>
                            <p className={styles.productCategory}>{product.category}</p>
                            <div className={styles.productPrice}>
                                <span className={styles.currentPrice}>${product.price}</span>
                                {product.discount > 0 && (
                                    <span className={styles.originalPrice}>
                                        ${(product.price / (1 - product.discount / 100)).toFixed(2)}
                                    </span>
                                )}
                            </div>
                            <div className={styles.productRating}>
                                <span className={styles.stars}>{'★'.repeat(Math.floor(product.rating))}</span>
                                <span className={styles.ratingNumber}>({product.rating})</span>
                                <span className={styles.reviewCount}>{product.reviews} reviews</span>
                            </div>
                        </div>
                    </Link>
                ))}
            </div>
        </div>
    );
}