import React from 'react';
import { Link } from 'react-router-dom';
import './About.css';

// function githubClick() {
// 	window.location.href = `https://github.com/younghwani`;
// }

export default function About() {
	return (
		<div className="aboutContainer">
			<h1>About</h1>
			<h2>
				Copyright by{' '}
				<Link
					to={{ pathname: 'https://github.com/younghwani' }}
					target="_blank"
				>
					Younghwani
				</Link>
			</h2>
		</div>
	);
}
