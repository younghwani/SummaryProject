import React, { useState } from 'react';
import { Container, Form, FormGroup, Input, Label, Button } from 'reactstrap';

const Main = () => {
	const [input, setInput] = useState('');

	function handleSubmit(event) {
		event.preventDefault();
		window.location.href = `/result/${input}`;
	}

	function onInputChange(event) {
		const target = event.target;
		const value = target.value;
		setInput(value);
	}

	return (
		<div className="mainContainer">
			<div>
				<h1>Main</h1>
				<p>요약 테스트</p>
			</div>
			<Container>
				<Form onSubmit={handleSubmit}>
					<Label for="input">요약할 텍스트</Label>
					<br />
					<Input
						type="text"
						name="input"
						id="input"
						onChange={onInputChange}
						placeholder="Input text.."
					/>
					<br />
					<br />
					<FormGroup>
						<Button color="success" type="submit">
							요약하기
						</Button>{' '}
						<Button color="danger" href={`/`}>
							취소
						</Button>
					</FormGroup>
				</Form>
			</Container>
		</div>
	);
};

export default Main;
