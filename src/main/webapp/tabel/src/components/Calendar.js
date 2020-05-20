import React from 'react';
import { Table} from 'antd';
import axios from 'axios';
import Department from "./Departments";

export default class Calendar extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            dataFromDataSource: [],
            columns: []
        };
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/getAll`, {
            params: {
                month: this.props.month,
                departmentId: 1,
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
        this.fillColumns(30);
    }

    fillColumns(i) {
        for (let m = 1; m <= i; m++) {
            this.columns.push({
                title: m,
                dataIndex: 'codes'+ m,
                key: 'codes' + m,
            });
        }
    }

    testData = [
        {
            key:'1',
            fullName: 'John',
            position: 'Manager',
            id: 2,
            codes1: "ZZZ",
        },
    ];

    columns = [
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
    ];

    render() {
        return (
        <div>
            <Table  columns={this.columns} dataSource={this.state.dataFromDataSource}  pagination={false} />
        </div>
        )
    }
}