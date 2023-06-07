#!/usr/bin/env python3
# -*- coding: utf-8 -*-


import yfinance as yf
import pandas as pd
import matplotlib.pyplot as plt

# 定义股票代码
ticker = "^TWII"

# 创建 Ticker 对象
index = yf.Ticker(ticker)

# 获取历史数据
hist = index.history(period="5y")

# 重新采样为每月的数据，并取每个月的最后一条数据
hist = hist.resample('M').last()

# 保留收盘价和交易量数据
hist = hist[['Close', 'Volume']]

# 格式化日期为 'YYYY-MM'
hist.index = hist.index.strftime('%Y-%m-%d')

# 将收盘价四舍五入到两位小数
hist['Close'] = hist['Close'].round(2)
hist.to_csv('data.csv')

# 创建一个图表对象
plt.figure(figsize=(14, 8))

# 绘制收盘价折线图
plt.subplot(2, 1, 1)
plt.plot(pd.to_datetime(hist.index), hist['Close'], label='Close')
plt.title('月收盘价')
plt.ylabel('价格')
plt.savefig('close.png')
plt.legend()

# 绘制交易量柱状图
plt.subplot(2, 1, 2)
plt.bar(hist.index, hist['Volume'], label='交易量')
plt.xticks(hist.index[::3], rotation=45)  # 每三个月显示一个x轴刻度标签，并进行旋转
plt.ylabel('交易量')
plt.savefig('volume.png')
plt.legend()

# 自动调整日期刻度间距
plt.tight_layout()

# 显示图表
plt.show()


