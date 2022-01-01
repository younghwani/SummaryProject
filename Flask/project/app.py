from flask import Flask, jsonify, request
from transformers import pipeline
import torch
from transformers import PreTrainedTokenizerFast
from transformers.models.bart import BartForConditionalGeneration

app = Flask(__name__)

# use summarize model (pipeline)
summarizer = pipeline('summarization')

# use kobart model
model = BartForConditionalGeneration.from_pretrained('../kobart_summary')
tokenizer = PreTrainedTokenizerFast.from_pretrained('gogamza/kobart-base-v1')

@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/test', methods=['GET'])
def test():
    text = "This is.... Test... Flask..."
    return text

@app.route('/summarize', methods=['GET'])
def predict():
    text = request.args.get("text")
    summary = summarizer(text, max_length=100, min_length=30, do_sample=False)
    return summary[0]['summary_text']

@app.route('/kobartSum', methods=['GET'])
def kobart_summarize():
    text = request.args.get("text")
    input_ids = tokenizer.encode(text)
    input_ids = torch.tensor(input_ids)
    input_ids = input_ids.unsqueeze(0)
    output = model.generate(input_ids, eos_token_id=1, max_length=512, num_beams=5)
    output = tokenizer.decode(output[0], skip_special_tokens=True)
    return output

if __name__ == '__main__':
    app.run()
