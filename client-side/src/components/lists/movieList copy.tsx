import {Datagrid, EditButton, List, TextField} from 'react-admin'

export const CategoriesList = () => (
	<List>
		<Datagrid rowClick='show'>
			<TextField source='id' />
			<TextField source='name' />
			<EditButton label='Edit' />
		</Datagrid>
	</List>
)
