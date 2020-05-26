import React from 'react';
import {Table} from 'antd';
import axios from 'axios';

export default class Calendar extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            dataFromDataSource: [],
            columns:[],
            daysList: [],
        }
    }

    componentDidUpdate(prevProps,prevState, snapshot) {
        if (prevProps.departmentId !== this.props.departmentId) {
            this.getRecordsByMonthAndDepartment();
        }
    }

    getRecordsByMonthAndDepartment() {
        axios.get(`http://localhost:8080/getRecordsByMonthAndDepartment`, {
            params: {
                month: this.props.month,
                departmentId: this.props.departmentId,
            }
        })
            .then(res => {
                const dataList = res.data.map((d) => {
                    d.codes.forEach((code, index) => {
                        d[`codes${index+1}`] = code;
                    })
                    return d;
                });
                this.setState({dataFromDataSource : dataList});
            });
        this.fillColumns(this.props.daysList);
    }

    componentDidMount() {
        this.getRecordsByMonthAndDepartment();
    }

    fillColumns(arr) {
        const columns = [
            {
                title: 'ФИО',
                dataIndex: 'fullName',
                key: 'fullName',
            },
            {
                title: 'Должность',
                dataIndex: 'position',
                key: 'position',
            },
            {
                title: 'Номер',
                dataIndex: 'id',
                key: 'id',
            },
            {
                title: 'Итого',
                dataIndex: 'monthSummary',
                key: 'monthSummary',
            }];

        for (let m = 1; m <= arr.length; m++) {
            columns.push({
                title: m,
                dataIndex: 'codes' + m,
                key: 'codes' + m,
                align: 'center',
                className: arr[m-1] === 1 ? 'day-off' : 'regular-day',
            });
        }
        return columns;
    }

    render() {
        const columns = this.fillColumns(this.props.daysList);
        return (
        <div>
            <Table
                scroll={{x: 'max-content'}}
                columns={columns}
                dataSource={this.state.dataFromDataSource}
                pagination={false}
                bordered
            />
        </div>
        )
    }
}